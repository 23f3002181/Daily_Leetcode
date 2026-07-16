class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length ;
        int m = arr2.length ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max, arr1[i]) ;
        }
        int[] count = new int[max + 1] ;
        for(int i : arr1){
            count[i]++ ;
        }
        int j = 0 ;
        for(int i : arr2){
            while(count[i] > 0){
                arr1[j] = i ;
                count[i]-- ;
                j++ ;
            }
        }
        for(int i = 0 ; i < max+1 ; i++){
            while(count[i] > 0){
                arr1[j] = i ;
                count[i]-- ;
                j++ ;
            }
        }
        return arr1 ;
    }
}
