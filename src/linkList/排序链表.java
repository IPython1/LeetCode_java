package linkList;

import java.util.List;

public class 排序链表 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newHead=sortList(node1);
        while(newHead!=null){
            System.out.print(newHead.val+" ");
            newHead=newHead.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        //当题目输入的 head == None 时，直接返回 None 对应示例三的情况
        if(head==null||head.next==null) return head;//说明分割的只剩一个节点了
        //分割
        ListNode mid=getMiddleNode(head);
        ListNode temp=mid.next;
        mid.next=null;//将链表切断
        ListNode left=sortList(head);//排序左半部分
        ListNode right=sortList(temp);//排序右半部分
        //合并
        ListNode newHead=mergeTwoLists(left,right);
        return newHead;
    }
    //快慢指针找中间节点
    public static ListNode getMiddleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;//偶数个的话就是中间节点的左边那个
    }
    //合并链表使其有序
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
