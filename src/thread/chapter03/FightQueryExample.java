package thread.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @program: IdeaJava
 * @Date: 2019/12/24 14:14
 * @Author: lhh
 * @Description:
 */
public class FightQueryExample {
    //合作的各大航空公司
    private static List<String> fightCompany = Arrays.asList(
            "CSA","CEA","HNA"
    );

    private static List<String> search(String original,String dest)
    {
        //常见查询航班信息的线程列表
        final List<String> result = new ArrayList<>();
        List<FightQueryTask> tasks = fightCompany.stream()
            .map(f -> createSearchTask(f,original,dest))
                .collect(toList());

        //分别启动这几个线程
        tasks.forEach(Thread::start);

        //分别调用每一个现成的Join方法，阻塞当前线程
        tasks.forEach(t->
        {
            try
            {
                t.join();
            }catch (InterruptedException e){}
        });

        //在此之前，当前线程会阻塞住，获取每一个查询线程的结果，并且加入到result中
        tasks.stream().map(FightQuery::get).forEach(result::addAll);

        return result;
    }

    private static FightQueryTask createSearchTask(String fight,
                                                   String original,String dest)
    {
        return new FightQueryTask(fight,original,dest);
    }

    public static void main(String[] args)
    {
        List<String> results = search("SH","BJ");
        System.out.println("=========result==========");
        results.forEach(System.out::println);
    }

}
