package easy;

/**
 * @author dongyajie
 * @date 2025/8/7 10:29
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表 {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode dummy=new ListNode(-1);//虚拟头指针
        ListNode cur=dummy;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            } else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        if (list1!=null) cur.next=list1;
        if (list2!=null) cur.next=list2;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = mergeTwoLists(list1, list2);
        while (list3!=null){
            System.out.println(list3.val);
            list3 = list3.next;
        }
    }
}
