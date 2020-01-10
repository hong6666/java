package lhh.pattern.strategyPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2020/1/10 11:34
 * @Author: lhh
 * @Description: 策略模式
 */
public class StrategyApp {
    public static void main(String[] args)
    {
        List<Person> list = new ArrayList<>();
        list.add(new Person("lhh",21));
        list.add(new Person("zq",20));
        list.add(new Person("lyx",20));
        list.add(new Person("xht",22));

        Environment env = new Environment();
        SortByAgeAsc ageAsc = new SortByAgeAsc();
        env.setStrategy(ageAsc);
        env.sort(list);
        System.out.println(list);

        Environment env2 = new Environment(new SortByAgeDesc());
        env2.sort(list);
        System.out.println(list);
    }
}
interface Strategy
{
    void sort(List list);
}
class SortByAgeAsc implements Strategy
{
    @Override
    public void sort(List list) {
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int n = o1.getAge() - o2.getAge();
                if (n == 0)
                {
                    return o1.getId() - o2.getId();
                }
                return n;
            }
        });
    }
}
class SortByAgeDesc implements Strategy
{
    @Override
    public void sort(List list) {
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int n = o2.getAge() - o1.getAge();
                if( n == 0) return o1.getId() - o2.getId();
                return n;
            }
        });
    }
}
class Environment
{
    private Strategy strategy;
    public Environment(){}
    public Environment(Strategy strategy){
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Person> list)
    {
        strategy.sort(list);
    }
}
class Person
{
    private int id;
    private String name;
    private int age;
    private static int num = 1;
    public Person(String name,int age)
    {
        this.id = num++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}