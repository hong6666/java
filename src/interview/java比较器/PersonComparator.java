package interview.java比较器;

import java.util.Comparator;

/**
 * PersonComparator
 *
 * @author 李弘昊
 * @since 2020/9/20
 */
public class PersonComparator implements Comparator<Person> {

    String orderby;
    String orderType;
    public PersonComparator(String  orderby,String orderType) {
        this.orderby = orderby;
        this.orderType = orderType;
    }

    @Override
    public int compare(Person o1, Person o2) {
        int result = 0;
        if ("id".equals(orderby)) {
            result = o1.getId()>o2.getId()?1:(o1.getId()==o2.getId()?0:-1);
        }
        if ("name".equals(orderby)) {
            result = o1.getName().compareTo(o2.getName());
        }
        if ("DESC".equals(orderType)) {
            result = 0 - result;
        }
        return result;
    }
}
