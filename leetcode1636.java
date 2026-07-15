class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>() ;
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) + 1) ;
        }
        List<Integer> list = new ArrayList<>() ;
        for(int num : nums){
            list.add(num) ;
        }
        Collections.sort(list, (a,b) -> {
            if(!freq.get(a).equals(freq.get(b))) return freq.get(a) - freq.get(b) ;
            return b - a ;
        }) ;
        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = list.get(i) ;
        }
        return nums ;
    }
}
