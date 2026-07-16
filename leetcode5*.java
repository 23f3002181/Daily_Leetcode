class Solution {
    public boolean solve(String s, int i, int j, Boolean[][] dp) {
        if (i >= j)
            return true;
        if(dp[i][j] != null){
            return dp[i][j] ;
        }
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(s, i + 1, j - 1, dp);
            return dp[i][j] ;
        }
        dp[i][j] = false ;
        return false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n] ;
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j, dp)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
