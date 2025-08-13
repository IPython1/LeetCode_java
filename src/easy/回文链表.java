package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:28
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 * 快慢指针找中间节点  回文链表根据双指针判断
 */
public class 回文链表 {
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
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(isPalindrome(node1));
    }
    //思路是快慢指针找中间节点，然后反转链表，然后判断两个链表的值是否相等 如果全部相等的话就是回文链表 如果任意一个不相等则不是回文链表
    public static boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddle(head);
        //这里需要将middle前边那个节点的next指针设置为空吧？ 或者直接以newhead的长度进行遍历 避免这个问题
        ListNode reverseHead = reverseList(middle);
        return isEqual(head,reverseHead);
    }
    //1.找到中间节点
    public static ListNode findMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //2.反转链表
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
    //3.判断两个链表是否相等
    public static boolean isEqual(ListNode head1,ListNode head2) {
        while (head2!=null){
            if (head1.val!=head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }

}
