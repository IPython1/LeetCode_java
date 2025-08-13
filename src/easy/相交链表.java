package easy;

import config.ListNode;

/**
 * @author dongyajie
 * @date 2025/8/7 10:27
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并   返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 */
public class 相交链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node3; // 这里创建了一个环，使链表相交于node3

        System.out.println(getIntersectionNode(node1, node2).val); // 输出相交节点的值
    }
    //相交链表就是走完一条链表后，再走另一条链表 直到两个链表相遇
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
