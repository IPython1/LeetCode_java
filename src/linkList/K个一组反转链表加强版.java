package linkList;

import util.ListNode;

public class K个一组反转链表加强版 {
    //不足k个也进行反转
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表
    public static ListNode reverseKGroup(ListNode head, int k) {
            //先计算总长度 有几个K
            int len=0;
            ListNode p1=head;
            while(p1!=null){
                len++;
                p1=p1.next;
            }
            int count=len/k;//反转count次
            ListNode dummy=new ListNode(-1);
            dummy.next=head;
            ListNode p=dummy;
            ListNode pre=null;
            ListNode cur=p.next;
            while(count--!=0){
                for(int i=0;i<k;i++){//对每一组的k个数进行反转
                    ListNode next=cur.next;
                    cur.next=pre;
                    pre=cur;
                    cur=next;
                }
                //提前存储p应该在的位置 后续更新p的位置
                ListNode nxt=p.next;
                p.next.next=cur;
                p.next=pre;
                p=nxt;
            }
            //后续不足k个也继续反转 就是对后续节点进行反转链表的操作 然后p指针指向后边反转节点的新头节点即可
            ListNode preN=null;
            while(cur!=null){
                ListNode next=cur.next;
                cur.next=preN;
                preN=cur;
                cur=next;
            }
            p.next=preN;
            return dummy.next;
    }

    public static void main(String[] args) {
        //构造一个链表 1->2->3->4->5 k=3
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;

        ListNode res=reverseKGroup(node1, 3);//返回反转后新的头节点
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
        System.out.println();
    }
}
