import util.ListNode;

public class 重排链表 {
    // 实现链表重排功能
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // 找到链表中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 反转后半部分链表
        ListNode prev = null, curr = slow.next;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // 将原链表和反转后的链表合并
//        slow.next = null;
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            
            first.next = second;
            second.next = firstNext;
            
            first = firstNext;
            second = secondNext;
        }
    }
    
    // 添加main函数测试用例
    public static void main(String[] args) {
        重排链表 solution = new 重排链表();
        
        // 创建测试链表: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        System.out.println("原始链表:");
        printList(head);
        
        solution.reorderList(head);
        
        System.out.println("重排后链表:");
        printList(head);
    }
    
    // 辅助函数用于打印链表
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}