package lhh.nowcoder;

/**
 * @program: IdeaJava
 * @Date: 2019/12/25 11:10
 * @Author: lhh
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTailApp {
    public static ListNode findKthToTail(ListNode head,int k) {
        ListNode p = head;
        ListNode q = head;
        int count = 0;
        for(;p != null;p = p.next,count++)
        {
            if(count >= k)
            {
                q = q.next;
            }
        }
        return k>count?null:q;
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
        ListNode getKNode = findKthToTail(a,2);
        System.out.println(getKNode.val);
    }
}
