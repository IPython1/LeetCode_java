package linkList;

import util.ListNode;

/**
 * 双指针判断是否相交
 */
public class 相交链表 {
    //走完a走b
    public static void main(String[] args) {
        ListNode la=new ListNode(4);
        ListNode lb=new ListNode(5);

        ListNode nodecommon1=new ListNode(8);
        ListNode nodecommon2=new ListNode(4);
        ListNode nodecommon3=new ListNode(5);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(6);
        ListNode node11=new ListNode(1);
        la.next=node1;
        node1.next=nodecommon1;
        nodecommon1.next=nodecommon2;
        nodecommon2.next=nodecommon3;
        //--
        lb.next=node2;
        node2.next=node11;
        node11.next=nodecommon1;
        ListNode res=getIntersectionNode(la, lb);
        System.out.println(res.val);

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode pa=headA;
        ListNode pb=headB;
        while(pa!=pb){
            pa=pa!=null?pa.next:headB;
            pb=pb!=null?pb.next:headA;
        }
        return pa;
    }
}
