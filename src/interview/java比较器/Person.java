package interview.java比较器;

/**
 * Person
 *
 * @author 李弘昊
 * @since 2020/9/20
 */
public class Person implements Comparable{
    private int id;
    private String name;

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.getId()>p.getId()?1:(this.getId()==p.getId()?0:-1);
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

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person() {}
}
