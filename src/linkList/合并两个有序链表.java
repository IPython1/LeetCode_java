package linkList;

import java.util.List;

public class 合并两个有序链表 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        head1.next=new ListNode(2);
        head1.next.next=new ListNode(4);
        ListNode head2=new ListNode(1);
        head2.next=new ListNode(3);
        head2.next.next=new ListNode(4);
        ListNode cur=mergeTwoLists(head1,head2);
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
    //使用双指针 两个指针分别指向两个链表 然后进行合并
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                newHead.next = p1;
                p1 = p1.next;
                newHead=newHead.next;
            }else {
                newHead.next = p2;
                p2 = p2.next;
                newHead=newHead.next;
            }
        }
        //检查以下P1还是P2谁走完了  没走完把剩下的接上
        if (p1 == null) {
            newHead.next = p2;
        }
        if (p2 == null) {
            newHead.next = p1;
        }
        return dummy.next;
    }
}
