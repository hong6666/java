package lhh.dataStructureAndAlgorithm;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 14:17
 * @Author: lhh
 * @Description:泛型
 */
public class GenericMethodTest {

    public static <E> void  printArray(E[] inputArray)
    {
        for (E element : inputArray)
        {
            System.out.printf("%s ",element);
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        Integer[] intArray = { 1, 3, 4, 5, 6};
        Double[] doubleArray = { 1.1, 2.1, 4.3, 4.2};
        Character[] charArray = { 'H', 'E', 'L', 'L','O'};

        System.out.print("整形数组元素为：");
        printArray(intArray);

        System.out.print("\n双精度型数组元素为：");
        printArray(doubleArray);

        System.out.print("\n字符型数组元素为：");
        printArray(charArray);



    }
}
