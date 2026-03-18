class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0, result = 0, maxf = 0;
        for(int r = 0; r < s.length(); r++){
            int index = s.charAt(r) - 'A';
            count[index]++;
            maxf = Math.max(maxf, count[index]);
            while((r - l + 1) - maxf > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;

        // HashMap<Character, Integer> count = new HashMap<>();
        // int l = 0, result = 0, maxf = 0;
        // for(int r = 0; r < s.length(); r++){
        //     count.put(s.charAt(r), count.getOrDefault(s.charAt(r),0) + 1);
        //     maxf = Math.max(maxf, count.get(s.charAt(r)));
        //     while((r - l + 1) - maxf > k){
        //         count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
        //         l++;
        //     }
        //     result = Math.max(result, r - l + 1);
        // }
        // return result;
    }
}
