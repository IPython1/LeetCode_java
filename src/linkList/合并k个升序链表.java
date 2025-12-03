package linkList;

import java.util.List;
import java.util.PriorityQueue;

public class 合并k个升序链表 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode[] lists=new ListNode[3];
        lists[0]=new ListNode(1);
        lists[0].next=new ListNode(4);
        lists[0].next.next=new ListNode(5);
        lists[1]=new ListNode(1);
        lists[1].next=new ListNode(3);
        lists[1].next.next=new ListNode(4);
        lists[2]=new ListNode(2);
        lists[2].next=new ListNode(6);
        ListNode newHead=mergeKLists(lists);
        while (newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

    }
    public static ListNode mergeKLists(ListNode[] lists) {
        // 如果链表数组为空，直接返回 null
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 创建一个最小堆（优先队列），用于存储所有链表的头节点
        PriorityQueue<ListNode> qu = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        // 遍历链表数组，将所有非空链表的头节点加入堆中 1 1 2
        for (ListNode node : lists) {
            if (node != null) {
                qu.add(node);
            }
        }

        // 不断从堆中取出最小节点，连接到合并后的链表中
        while (!qu.isEmpty()) {
            // 取出堆中的最小节点
            ListNode node = qu.poll();
            // 将最小节点连接到合并后的链表中
            p.next = node;
            // 如果最小节点的下一个节点不为空，将其加入堆中
            if (node.next != null) {
                qu.add(node.next);
            }
            // 移动 p 指针，使其指向新的尾节点
            p = p.next;
        }

        // 返回合并后的链表头节点（虚拟头节点的下一个节点）
        return dummy.next;
    }

}
