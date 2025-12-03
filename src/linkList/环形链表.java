package linkList;

import java.util.List;

public class 环形链表 {
    //快慢指针判断是否有环 有环的话快慢指针会相遇
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(2);

        ListNode node3=new ListNode(0);

        ListNode node4=new ListNode(-4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        System.out.println(hasCycle(node1));


    }
    public static boolean hasCycle(ListNode head) {
        ListNode  slow=head;
        ListNode  fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){return true;}
        }
        return false;
    }
}
