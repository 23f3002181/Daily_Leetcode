class TimeMap {
    private Map<String , List<Pair<Integer, String>>> map ;

    public TimeMap() {
       map = new HashMap<>() ; 
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key , k -> new ArrayList<>()).add(new Pair<>(timestamp, value)) ;
    }

    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> values = map.getOrDefault(key , new ArrayList<>()) ;
        String result = "" ;
        int low = 0 , high = values.size() - 1 ;
        while(low <= high){
            int mid = (low + high) / 2 ;
            if(values.get(mid).getKey() <= timestamp){
                result = values.get(mid).getValue() ;
                low = mid + 1 ;
            } else{
                high = mid - 1 ;
            }
        }
        return result ;
    }
    // private Map<String , TreeMap<Integer , String>> map ;

    // public TimeMap() {
    //    map = new HashMap<>() ; 
    // }
    
    // public void set(String key, String value, int timestamp) {
    //     map.computeIfAbsent(key , k -> new TreeMap<>()).put(timestamp, value) ;
    // }
    
    // public String get(String key, int timestamp) {
    //     if(!map.containsKey(key)) return "" ;
    //     TreeMap<Integer, String> timestamps = map.get(key) ;
    //     int bestTime = -1 ;
    //     for(Integer t : timestamps.keySet()){
    //         if(t <= timestamp && t > bestTime){
    //             bestTime = t ;
    //         }
    //     }
    //     if(bestTime == -1) return "" ;
    //     return timestamps.get(bestTime) ;
    // }
}
