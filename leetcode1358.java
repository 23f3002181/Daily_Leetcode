class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = new int[]{-1,-1,-1};
        int count = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int index = s.charAt(i) - 'a';
            last[index] = i ;
            if(last[0] != -1 && last[1] != -1 && last[2] != -1){
                count += 1 + Math.min(last[0], Math.min(last[1],last[2]));
            }
        }
        return count ;
    }
}
