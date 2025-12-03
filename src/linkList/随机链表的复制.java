package linkList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 随机链表的复制 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node node1=new Node(7);
        Node node2=new Node(13);
        Node node3=new Node(11);
        Node node4=new Node(10);
        Node node5=new Node(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node1.random=null;
        node2.random=node1;
        node3.random=node5;
        node4.random=node3;
        node5.random=node1;
        Node newHead=copyRandomList(node1);
        while(newHead!=null){
            System.out.print(newHead.val+" ");
            newHead=newHead.next;
        }

    }
    public static Node copyRandomList(Node head) {
        Map<Node,Node> mp=new HashMap<>();
        //因为还有一个随机指针所以不能这样直接复制 需要val next random指针都进行一遍复制
        //不能一次遍历就复制所有指针的原因是：random指针指向的节点可能还没有被创建
        Node cur=head;
        while(cur!=null){
            mp.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            mp.get(cur).next=mp.get(cur.next);
            mp.get(cur).random=mp.get(cur.random);
            cur=cur.next;
        }
        return mp.get(head);

    }
}
