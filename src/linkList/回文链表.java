package linkList;

import java.util.List;


public class 回文链表 {
    private static class  ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }
    public static void main(String[] args) {
        //双指针解决回文链表
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(head));
    }
    //找中间节点 反转 然后比对如果完全相同的话就是回文链表
    public static boolean isPalindrome(ListNode head) {
        ListNode mid=getMiddleNode(head);
        ListNode newHead=reverseList(mid.next);
        mid.next=null;
        while(head!=null){
            if(head.val != newHead.val){
                return false;
            }
            head=head.next;
            newHead=newHead.next;
        }
        return true;
    }
    public static ListNode getMiddleNode(ListNode head) {//这种写法如果是偶数个节点的话 就是中间两个节点的左边那个 刚好是要反转链表的头节点
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        return pre;
    }

}
