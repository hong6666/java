package lhh.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: IdeaJava
 * @Date: 2019/12/31 14:28
 * @Author: lhh
 * @Description:  输入一个链表，按链表从尾到头的顺序返回一个ArrayList（动态数组）。
 */
public class ReverseListNodeReturnArrayList {
    ArrayList arrayList = new ArrayList();
    public  ArrayList  reverseListNode(ListNode listNode)
    {
        if(listNode != null)
        {
            reverseListNode(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ReverseListNodeReturnArrayList myapp = new ReverseListNodeReturnArrayList();
        ArrayList myarr = myapp.reverseListNode(a);
        myarr.add(0,9);
        myarr.add(0,8);
        System.out.println(myarr);
    }
}
