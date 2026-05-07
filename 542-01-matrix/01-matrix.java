class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int m = mat.length , n=mat[0].length;
         Queue<int[]> q = new LinkedList<>();
         int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

         for(int i=0;i<m;i++){
            for(int j=0;j<n; j++){
                if(mat[i][j] == 0) q.offer(new int[]{i,j});
                else mat[i][j] = -1;
            }
         }
         while(!q.isEmpty()){
            int[] c = q.poll();
            for(int[] x: d){
                int r = c[0] + x[0];
                int col = c[1] + x[1];
                if(r>=0 && col>=0 && r<m && col<n && mat[r][col]==-1){
                    mat[r][col] = mat[c[0]][c[1]] + 1;
                    q.offer(new int[]{r,col});
                }
            }
         }
         return mat;
    }
}