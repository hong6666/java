//package interview.stringsomething;
//
//import com.sun.jdi.Value;
//
///**
// * EqualsTest
// * 判断相等可以用equals和equalsIgnoreCase(忽略大小写)
// * @author 李弘昊
// * @since 2020/6/3
// */
//public class EqualsTest {
//
//    /**
//     * String字符串的相等比较，String的底层结构是char[]数组，判断相等的时候，
//     * 挨个比较char数组中的字符是否相等
//     * @param anObject
//     * @return
//     */
//    public boolean stringEquals(Object anObject)
//    {
//        //判断内存地址是否相等
//        if (this == anObject)
//        {
//            return true;
//        }
//        //待比较对象是否Sring
//        if (anObject instanceof String)
//        {
//            String anotherString = (String) anObject;
//            int n = value.length;
//            //两个字符串的长度是否相等
//            if (n == anotherString.length())
//            {
//                char v1[] = value;
//                char v2[] = anotherString.toCharArray();
//                int i = 0;
//                //依次比较每个字符是否相等
//                while (n-- != 0)
//                {
//                    if (v1[i] != v2[i])
//                    {
//                        return false;
//                    }
//                    i++;
//                }
//                return true;
//            }
//            return false;
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        String str = "ss";
//        int s = 1;
//        System.out.println(str.equals(s));
//    }
//}
