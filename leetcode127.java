class Pair {
    String word ;
    int steps ;
    Pair(String word, int steps){
        this.word = word ;
        this.steps = steps ;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList) ;
        if(!wordSet.contains(endWord)) return 0 ;
        wordSet.remove(beginWord) ;
        Queue<Pair> q = new LinkedList<>() ;
        q.offer(new Pair(beginWord, 1)) ;
        while(!q.isEmpty()){
            Pair curr = q.poll() ;
            String word = curr.word ;
            int steps = curr.steps ;
            if(word.equals(endWord)){
                return steps ;
            }
            for(int i = 0 ; i < word.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] replacedCharArray = word.toCharArray() ;
                    replacedCharArray[i] = ch ;
                    String replacedWord = new String(replacedCharArray) ;
                    if(wordSet.contains(replacedWord)){
                        wordSet.remove(replacedWord) ;
                        q.offer(new Pair(replacedWord, steps + 1)) ;
                    }
                }
            }
        }
        return 0 ;
    }
}
