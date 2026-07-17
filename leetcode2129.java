class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder() ;
        String[] words = title.toLowerCase().split(" ") ;
        for(String word : words){
            if(word.length() > 2){
                sb.append(word.substring(0,1).toUpperCase() 
                        + word.substring(1) + " ") ;
            } else{
                sb.append(word + " ") ;
            }
        }
        return sb.toString().trim() ;
    }
}
