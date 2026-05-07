class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i=0;i<n ;i++){
            if(!visited[i]){
                provinces ++;
                Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    visited[i] = true;
                while(!q.isEmpty()){
                    int city = q.poll();
                    for(int j=0;j<n;j++){
                        if(isConnected[city][j] == 1 && !visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return provinces;
    }
}