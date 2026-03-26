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
        ListNode dummy = new ListNode(-1 , head) ;
        ListNode groupPrev = dummy ;
        while(true){
            ListNode Kth = getKth(groupPrev, k) ;
            if(Kth == null) break ;
            ListNode groupNext = Kth.next ;
            ListNode start = groupPrev.next ;
            reverseLL(start, groupNext) ;
            groupPrev.next = Kth ;
            groupPrev = start ;
        }
        return dummy.next ;
    }

    private ListNode getKth(ListNode curr , int k){
        while(curr != null && k > 0){
            curr = curr.next ;
            k-- ;
        }
        return curr ;
    }

    private void reverseLL(ListNode start, ListNode end){
        ListNode prev = end ;
        while(start != end){
            ListNode next = start.next ;
            start.next = prev ;
            prev = start ;
            start = next ;
        }
    }
}
