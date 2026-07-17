class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervallist =new ArrayList<>(Arrays.asList(intervals));
        intervallist.add(newInterval);
        Collections.sort(intervallist, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervallist.get(0);

        for(int i=0;i<intervallist.size();i++){
            int[] interval = intervallist.get(i);

            if(current[1] >= interval[0]){
                current[1] = Math.max(current[1],interval[1]);
            }else{
                res.add(current);
                current = interval;
            }
        }
        res.add(current);
        return res.toArray(new int[res.size()][]);
    }
}