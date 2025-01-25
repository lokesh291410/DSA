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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair<Integer, ListNode>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getKey(), b.getKey())
        );
        for(ListNode list : lists) {
            if(list != null) {
                Pair<Integer, ListNode> pair = new Pair<>(list.val, list);
                pq.add(pair);
            }
        }

        ListNode dummy = new ListNode(-1), temp = dummy;

        while(!pq.isEmpty()) {
            Pair<Integer, ListNode> pair = pq.poll();
            if(pair.getValue().next != null) 
                pq.add(new Pair<>(pair.getValue().next.val, pair.getValue().next));
            temp.next = pair.getValue();
            temp = temp.next;
        }

        return dummy.next;
    }
}