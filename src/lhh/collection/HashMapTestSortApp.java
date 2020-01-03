package lhh.collection;

import java.util.*;

/**
 * @program: IdeaJava
 * @Date: 2020/1/3 13:50
 * @Author: lhh
 * @Description:
 */

class User{
    public String name;
    public int age;
    public User(){}
    public User(String name ,int age)
    {
        this.name = name;
        this.age = age;
    }
    public String toString()
    {
        return "user [name="+ name+ ",age="+age+"]";
    }
}
public class HashMapTestSortApp {

    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> map)
    {
        // 首先拿到 map 的键值对集合
        Set<Map.Entry<Integer,User>> entrySet = map.entrySet();

        //将set集合转化为List集合，为什么，为了使用工具类的排序方法
        List<Map.Entry<Integer,User>> list = new ArrayList<>(entrySet);
        //使用collection集合工具对list进行排序，排序规则使用匿名内部类实现
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                //按照要求根据User的age的倒序进行排序
                return o2.getValue().age-o1.getValue().age;
            }
        });

        //创建一个新的有序的HashMap子类的集合
        LinkedHashMap<Integer,User> linkedHashMap = new LinkedHashMap<>();

        //将List中的数据存储在linkedHashMap中
        for(Map.Entry<Integer,User> entry:list)
        {
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }

    public static void main(String[] args) {

        HashMap<Integer, User> users = new HashMap<>();
        users.put(1,new User("张三",25));
        users.put(2,new User("李四",23));
        users.put(3,new User("王五",27));
        System.out.println(users);

        HashMap<Integer,User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);

    }
}
