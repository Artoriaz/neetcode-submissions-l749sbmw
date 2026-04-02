/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true) {
            ListNode kth= getKth(groupPrev, k);
            if(kth == null) {
                break;
            }
            ListNode newGroupHead = reverseList(groupPrev.next, kth.next);

            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = newGroupHead;
            groupPrev = oldGroupStart;

        }

        return dummy.next;
    }

    public ListNode reverseList(ListNode node, ListNode stoppingNode) {
        ListNode prev = stoppingNode;
        ListNode curr = node;
        while(curr != stoppingNode) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode getKth(ListNode node, int k) {
        while(node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}
