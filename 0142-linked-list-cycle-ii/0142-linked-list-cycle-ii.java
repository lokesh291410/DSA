/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; 
        ListNode fast = head; 
        int index = 0;
        while(fast != null && fast.next != null){
            
            slow  = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode pointer = head;
                while(pointer != slow){
                    pointer = pointer.next;
                    slow = slow.next;
                }    
                return pointer;
            }
        }
        return null;
    }
}