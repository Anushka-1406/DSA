class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int totalgas = 0;
        int currentgas = 0;
        for(int i =0;i<gas.length;i++){
            int fuelgain = gas[i] - cost[i];
            totalgas += fuelgain;
            currentgas += fuelgain;
            if(currentgas < 0){
                currentgas = 0;
                start = i+1;
            }
        }
        return totalgas < 0 ? -1 : start;
    }
}