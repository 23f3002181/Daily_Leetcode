class MedianFinder {
    private PriorityQueue<Integer> left; // smallHeap
    private PriorityQueue<Integer> right; // largeHeap

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> b - a);
        this.right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Automatically maintaining the ordering
        left.offer(num); 
        right.offer(left.poll()); // largest element in left goes to right 
        if (right.size() > left.size()) { // left is always equal to or one more than right 
            left.offer(right.poll()); // smallest element in right goes to left
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return (double) left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
