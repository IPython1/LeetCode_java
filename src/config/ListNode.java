package config;

/**
 * @author dongyajie
 * @date 2025/8/13 15:03
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {};
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
