package lhh.pattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 14:56
 * @Author: lhh
 * @Description:
 */
public class XiaoMei {
    List<Person> list = new ArrayList<>();

    public XiaoMei(){}

    public void addPerson(Person person){
        list.add(person);
    }

    //遍历list，把自己的通知发送给所有暗恋自己的人
    public void notifyPerson(){
        for(Person person : list){
            person.getMessage("你们过来吧，谁先过来谁就能陪我一起玩游戏！");
        }
    }

    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        LaoWang laoWang = new LaoWang();
        Laoli laoLi = new Laoli();

        //小王和小李在小美那里都注册一下
        xiaoMei.addPerson(laoLi);
        xiaoMei.addPerson(laoWang);

        xiaoMei.notifyPerson();
    }
}
