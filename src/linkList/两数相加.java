package linkList;

public class 两数相加 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){this.val=x;}
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode newHead=addTwoNumbers(l1,l2);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode p=dummy;
        int carry=0;//进位
        while(l1!=null||l2!=null||carry!=0){
            int curVal=0;//
            int sum=carry;//先把进位加上
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            curVal=sum%10;
            carry=sum/10;
            ListNode node=new ListNode(curVal);
            p.next=node;
            p=p.next;
        }
        return dummy.next;
    }
}
