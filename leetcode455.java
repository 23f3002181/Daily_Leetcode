class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n1 = s.length ;
        int n2 = g.length ;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0 , r = 0 ;
        while(l < n1 && r < n2){
            if(s[l] >= g[r]){
                r++ ;
            }
            l++ ;
        }
        return r ;
    }
}
