class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int majority = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
            if(map.get(num) > majority ){
                res = num;
                majority = map.get(num);
            }
        }
        return res;
    }
}