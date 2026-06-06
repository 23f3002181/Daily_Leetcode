class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList) ;
        Queue<List<String>> q = new LinkedList<>() ;
        List<String> ls = new ArrayList<>() ;
        ls.add(beginWord) ;
        q.offer(ls) ;
        List<String> usedOnLevel = new ArrayList<>() ;
        usedOnLevel.add(beginWord) ;
        int level = 0 ;
        List<List<String>> ans = new ArrayList<>() ;
        while(!q.isEmpty()) {
            List<String> curr = q.poll() ;
            if(curr.size() > level){
                level++ ;
                for(String str : usedOnLevel){
                    wordSet.remove(str) ;
                }
            }
            String word = curr.get(curr.size() - 1) ;
            if(word.equals(endWord)){
                if(ans.size() == 0){
                    ans.add(curr) ;
                } else if(ans.get(0).size() == curr.size()){
                    ans.add(curr) ;
                }
            }
            for(int i = 0 ; i < word.length() ; i++){
                for(char c = 'a' ; c <= 'z' ; c++){
                    char[] replaced = word.toCharArray() ;
                    replaced[i] = c ;
                    String replacedWord = new String(replaced) ;
                    if(wordSet.contains(replacedWord)){
                        curr.add(replacedWord) ;
                        List<String> temp = new ArrayList<>(curr) ;
                        q.offer(temp) ;
                        usedOnLevel.add(replacedWord) ;
                        curr.remove(curr.size() - 1) ; // backtrack
                    }
                }
            }
        }
        return ans ;
    }
}
