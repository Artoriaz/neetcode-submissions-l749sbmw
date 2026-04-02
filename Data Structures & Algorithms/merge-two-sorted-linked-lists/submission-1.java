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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // reference to the orginal the node list.
        ListNode dummy = new ListNode(0);
        // the thing we are moving with
        ListNode newList = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                newList.next = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                list2 = list2.next;
            }
            //move the newlist node forward
            newList = newList.next;
        }

        //if one of the arrayts is smaller than the other  we append the remainer 
        if(list1 != null) {
            newList.next = list1;
        } else {
            newList.next = list2;
        }

        return dummy.next;
    }
}