package linkList;

public class 两两交换链表中的节点 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
    }
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        ListNode newHead=swapPairs(head);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        //先计算总长度 有几个K
        int len=0;
        ListNode p1=head;
        while(p1!=null){
            len++;
            p1=p1.next;
        }
        int count=len/2;//反转count次
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode p=dummy;
        ListNode pre=null;
        ListNode cur=p.next;
        while(count--!=0){
            for(int i=0;i<2;i++){//对每一组的k个数进行反转
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
        return dummy.next;
    }

}
