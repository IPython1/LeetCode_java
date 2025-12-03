package linkList;

import java.util.List;

public class 删除链表的倒数第N个结点 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
    }
    //找到第N-1个结点 然后直接与第N+2的结点相连接 即可
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode newHead=removeNthFromEnd(l1,2);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //找到倒数第N-1个节点
        int len=0;
        ListNode p=head;
        while(p!=null){
            p=p.next;
            len++;
        }
        if(len==n) return head.next;//特殊情况处理
        ListNode cur=head;
        int count=len-n-1;//count的位置
        while(count-->0){
            cur=cur.next;
        }
        if(cur.next!=null){
            cur.next=cur.next.next;
        }
        return dummy.next;
    }
}
