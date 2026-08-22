class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int prevEnd = Integer.MIN_VALUE ;
        int count = 0 ;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];
            if(start < prevEnd){
                count++ ;
            } else {
                prevEnd = end ;
            }
        }
        return count ;
    }
}
