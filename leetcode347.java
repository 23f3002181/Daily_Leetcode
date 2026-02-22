class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i > 0 && index < k; i--){
            for(int n : freq[i]){
                res[index] = n;
                index++;
                if(index == k){
                    return res;
                }
            }
        }
        return res;

        // HashMap<Integer, Integer> count = new HashMap<>();
        // for(int num : nums){
        //     count.put(num, count.getOrDefault(num,0)+1);
        // }
        // PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // for(Map.Entry<Integer,Integer> entry : count.entrySet()){
        //     heap.offer(new int[]{entry.getValue(), entry.getKey()});
        //     if(heap.size() > k){
        //         heap.poll();
        //     }
        // }
        // int[] result = new int[heap.size()];
        // for(int i = 0; i < k; i++){
        //     result[i] = heap.poll()[1];
        // }
        // return result;

        // HashMap<Integer, Integer> count = new HashMap<>();
        // for(int num : nums){
        //     count.put(num, count.getOrDefault(num,0)+1);
        // }
        // List<int[]> list = new ArrayList<>();
        // for(Map.Entry<Integer,Integer> entry : count.entrySet()){
        //     list.add(new int[]{entry.getValue(), entry.getKey()});
        // }
        // list.sort((a,b) -> b[0]-a[0]);
        // int[] result = new int[k];
        // for(int i = 0; i < k; i++){
        //     result[i] = list.get(i)[1];
        // }
        // return result;
    }
}
