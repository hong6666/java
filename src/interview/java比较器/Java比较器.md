# Java比较器

转载修改自https://www.cnblogs.com/deityjian/p/11370630.html

## 常见比较器Comparable和Comparator

Comparable和Comparator都是java.包下的两个接口

Comparable和Comparator接口都是为了对类进行比较，像Integer，double等基本数据类型，java可以对他们进行比较，而对于类的比较，需要人工定义比较用到的字段比较逻辑。

## 一、Comparable

- Comparable可以认为是一个内比较器，实现了Comparable接口的类有一个特点，就是这些类是可以和自己比较的

- 若一个类实现了Comparable接口，就意味着该类支持排序。

- 实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。

### 1.1 Comparable接口

```JAVA
public interface Comparable<T> {
    // 这里入参也是T  所以是自己和自己比较的
    // 规则：this和t比较。  返回0表示两个对象相等
    // 返回正数： this > o
    // 返回负数： this < o
	public int compareTo(T o);
}
```

### 1.2 定义一个Person对象类

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable{
    private int id;
    private String name;
    
    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.getId()>p.getId()?1:(this.getId()==p.getId()?0:-1);
    }
}
```

### 1.3 排序

```java
public static void main(String[] args) {
        List<Person> peoples = new ArrayList<Person>();
        peoples.add(new Person(1,"a1"));
        peoples.add(new Person(3,"a3"));
        peoples.add(new Person(6,"a6"));
        peoples.add(new Person(2,"a2"));
        Collections.sort(peoples);
        System.out.println(peoples);

        Person[] pp = {new Person(3,"b3"),new Person(2,"b2")};
        Arrays.sort(pp);
        System.out.println(Arrays.toString(pp));
    }
```

## 二、Comparator

- Comparator是比较接口，我们如果需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)，那么我们就可以建立一个“该类的比较器”来进行排序，这个“比较器”只需要实现Comparator接口即可。
- 使用场景：
  - 对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较（大都是这种情况）
  - 对象实现了Comparable接口，但是开发者认为compareTo方法中的比较方式并不是自己想要的那种比较方式
- 若一个类要实现Comparator接口：它一定要实现compare(T o1, T o2) 函数，但可以不实现 equals(Object obj) 函数。
  - int compare(T o1, T o2) 是“比较o1和o2的大小”。
  - 返回“负数”，意味着“o1比o2小”；
  - 返回“零”，意味着“o1等于o2”；
  - 返回“正数”，意味着“o1大于o2”。

```JAVA
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2); 
    boolean equals(Object obj);
    //....还有其他很多方法
}
```

## 2.1实现方式

我们在某段代码中只需要用到一次比较，可以直接使用**匿名内部类**。如果我们需要经常用到一个对象类的比较，可以写一个专门的比较器工具类，这个比较器工具类可以写复杂的排序，二次比较等自定义的比较，

- 匿名内部类

  ```java
  Collections.sort(peoples, new Comparator<Person>() {
              @Override
              public int compare(Person o1, Person o2) {
                  return o1.getName().compareTo(o2.getName());
              }
          });
  System.out.println("#匿名内部类# " + peoples);
  ```

  

- 另外写一个通用的比较工具类

  - PersonComparator比较类实现了Comparator

  ```java
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
  ```

  - 使用比较工具类PersonComparator

  ```java
  Collections.sort(peoples, new PersonComparator("name","ASC"));
  System.out.println("#PersonComparator类# " + peoples);
  ```

  - 可以按照我们自己定义的比较器排序。并且Person是没有实现排序接口的哦，所以**是没有入侵性的**。

## 三、Comparable和Comparator区别比较

- Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
- Comparable是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。
- 而Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
- 用Comparable 简单， 只要实现Comparable 接口的对象直接就成为一个可以比较的对象，但是需要修改源代码。(有侵入性)
- 用Comparator 的好处是不需要修改源代码， 而是另外实现一个比较器， 当某个自定义的对象需要作比较的时候，把比较器和对象一起传递过去就可以比大小了， 并且在Comparator里面用户可以自己实现复杂的可以通用的逻辑，使其可以匹配一些比较简单的对象，那样就可以节省很多重复劳动了。

**四、其他**

**Comparator接口中的默认方法和静态方法**

TODO



