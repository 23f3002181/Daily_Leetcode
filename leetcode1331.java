class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length ;
        int[] sortedArr = arr.clone() ;
        Arrays.sort(sortedArr) ;
        Map<Integer,Integer> rankMap = new HashMap<>() ;
        int rank = 1 ;
        for(int i : sortedArr){
            if(!rankMap.containsKey(i)){
                rankMap.put(i, rank) ;
                rank++ ;
            }
        }
        int[] res = new int[n] ;
        for(int i = 0 ; i < n ; i++){
            res[i] = rankMap.get(arr[i]) ;
        }
        return res ;
    }
}
