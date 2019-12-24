package lhh.nowcoder;

/**
 * @program: IdeaJava
 * @Date: 2019/12/23 17:32
 * @Author: lhh
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 */
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution14ReverseList {
    public static ListNode reverseList(ListNode head)
    {
        ListNode pre = null;
        ListNode p = null;
        if(head == null || head.next == null)return head;
        else
        {
            while(head != null)
            {
                p = head.next;
                head.next = pre;
                pre = head;
                head = p;
            }
            return pre;
        }
    }

    public static void showListNode(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
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
        showListNode(a);
        showListNode(reverseList(a));
    }

}
