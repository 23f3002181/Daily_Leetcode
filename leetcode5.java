class Solution {
    public boolean solve(String s, int i, int j) {
        if (i >= j)
            return true;
        if (s.charAt(i) == s.charAt(j)) {
            return solve(s, i + 1, j - 1);
        }
        return false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j)) {
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
