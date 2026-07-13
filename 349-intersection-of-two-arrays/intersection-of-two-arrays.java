class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                ans.add(num);
                map.remove(num);
            }
        }
        int[] finalans = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            finalans[i] = ans.get(i);
        }
        return finalans;
    }
}