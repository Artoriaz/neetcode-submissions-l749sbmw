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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size =0;
        ListNode tail = head;
        //finding the size.

        while(tail != null) {
           tail = tail.next;
           size++;
        }
        if(n == size) {
            return head.next;
        }
        tail = head;
        int m =1;
        while(tail != null) {   
            if(m + 1 ==  size - n  + 1) {
                tail.next = tail.next.next;
                return head;
            }
            tail= tail.next;
            m++;

        }

        return head;


    }
}
