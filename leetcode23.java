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
        if(lists.length == 0) return null ;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val) ;
        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list) ;
            }
        }
        ListNode dummy = new ListNode(-1) ;
        ListNode curr = dummy ;
        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll() ;
            curr.next = minNode ;
            curr = curr.next ;
            minNode = minNode.next ;
            if(minNode != null){
                minHeap.offer(minNode) ;
            }
        }
        return dummy.next ;

        // List<Integer> nodes = new ArrayList<>() ;
        // for(ListNode list : lists){
        //     while(list != null){
        //         nodes.add(list.val) ;
        //         list = list.next ;
        //     }
        // }
        // Collections.sort(nodes) ;
        // ListNode dummy = new ListNode(0) ;
        // ListNode curr = dummy ;
        // for(int node : nodes){
        //     curr.next = new ListNode(node) ;
        //     curr = curr.next ;
        // }
        // return dummy.next ;
    }
}
