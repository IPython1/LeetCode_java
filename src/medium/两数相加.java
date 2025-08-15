package medium;

import config.ListNode;

/**
 * @author dongyajie
 * @date 2025/8/14 11:31
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class 两数相加 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node4.next = node5;
        ListNode node6 = new ListNode(4);
        node5.next = node6;
        ListNode newHead=addTwoNumbers(node1, node4);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
    //最后返回的是一个表示和的链表
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        int carry=0;//表示进位  （5+6）%10拿出来那个值 （5+6）/10!=0的话说明有进位
        while (l1!=null||l2!=null||carry!=0){
            int curNum=carry;   //这里首先加上进位
            if(l1!=null){
                curNum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                curNum+=l2.val;
                l2=l2.next;
            }
            carry=curNum/10;    //进位 进位是需要加在下一次计算的数字上的
            curNum=curNum%10;
            cur.next=new ListNode(curNum);
            cur=cur.next;
        }
        return dummy.next;
    }
}
