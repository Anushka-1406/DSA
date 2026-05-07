class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length , n = grid[0].length, count=0;
        Queue<int[]> q = new LinkedList<>();
        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';

                    while(!q.isEmpty()){
                        int[] c = q.poll();
                        for(int[] x : d){
                            int r = c[0] + x[0];
                            int col = c[1] + x[1];
                            if(r>=0 && col>=0 && r<m && col<n && grid[r][col] == '1'){
                                grid[r][col] = '0';
                                q.offer(new int[]{r,col});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}