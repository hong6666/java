package interview.java比较器;

import java.util.*;

/**
 * TestAppA
 *
 * @author 李弘昊
 * @since 2020/9/20
 */
public class TestAppA {

    public static void main(String[] args) {
        List<Person> peoples = new ArrayList<Person>();
        peoples.add(new Person(1,"a1"));
        peoples.add(new Person(3,"a3"));
        peoples.add(new Person(6,"a6"));
        peoples.add(new Person(2,"a2"));
        Collections.sort(peoples);
        System.out.println("#111#" + peoples);

        Collections.sort(peoples, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Collections.sort(peoples, (o1,o2) -> o1.getName().compareTo(o2.getName()) );
        Collections.sort(peoples, Comparator.comparing(Person::getName));
        System.out.println("#匿名内部类# " + peoples);
        Collections.sort(peoples, new PersonComparator("name","ASC"));
        System.out.println("#匿名内部类# " + peoples);


        Person[] pp = {new Person(3,"b3"),new Person(2,"b2")};
        Arrays.sort(pp);
        System.out.println(Arrays.toString(pp));


    }
}
