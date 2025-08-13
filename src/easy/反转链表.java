package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:28
 */
public class 反转链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
        System.out.println("===================");
    }
}
