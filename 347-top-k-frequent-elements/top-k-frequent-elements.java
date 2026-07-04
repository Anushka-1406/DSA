class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqmap = new HashMap<>();
        for(int num:nums){
            freqmap.put(num,freqmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> minheap = new PriorityQueue<>(
            (a,b) -> a[1] -b[1]
        );

        for(Map.Entry<Integer,Integer> entry : freqmap.entrySet()){
            minheap.offer(new int[]{entry.getKey() , entry.getValue()});

            if(minheap.size() > k){
                minheap.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = minheap.poll()[0];
        }
        return result;
    }
}