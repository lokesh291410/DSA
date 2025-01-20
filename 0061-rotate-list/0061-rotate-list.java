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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int len = 0;
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            len++;
            curr = curr.next;
        }
        len = len + 1;
        curr.next = head;
        ListNode temp = head;
        System.out.println(len);
        k = k%len;
        for(int i=0; i<len-k-1; i++) {
            temp = temp.next;
        }
        ListNode ans = temp.next;
        temp.next = null;

        return ans;
    }
}