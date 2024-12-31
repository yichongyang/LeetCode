package list.medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in
 * the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 *
 * Example 4:
 * Input: head = [1,2,3]
 * Output: [2,1,3]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }

        return dummy.next;
    }
}
