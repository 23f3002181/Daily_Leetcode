class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
        
        // k = nums.length - k + 1 ;
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        // for(int num : nums){
        //     maxHeap.offer(num);
        //     if(maxHeap.size() > k){
        //         maxHeap.poll();
        //     }
        // }
        // return maxHeap.peek();
    }
}
