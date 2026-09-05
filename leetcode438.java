class Solution {
    public boolean allZeroes(int[] count){
        for(int c : count){
            if(c != 0) return false ;
        }
        return true ;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()) return ans ;
        int count[] = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            count[p.charAt(i) - 'a']++ ;
            count[s.charAt(i) - 'a']-- ;
        }
        if(allZeroes(count)) ans.add(0);
        for(int i = p.length() ; i < s.length() ; i++){
            count[s.charAt(i) - 'a']-- ;
            count[s.charAt(i - p.length()) - 'a']++ ;
            if(allZeroes(count)) ans.add(i - p.length() + 1);
        }
        return ans ;
    }
}
