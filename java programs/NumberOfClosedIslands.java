public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        //precomputation
        for(int i=0;i<n;i++){
            if(grid[i][0]== 0) dfs(i,0,n,m,grid);
            if(grid[i][m-1]== 0) dfs(i,m-1,n,m,grid);
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]== 0) dfs(0,j,n,m,grid);
            if(grid[n-1][j]== 0) dfs(n-1,j,n,m,grid);
        }
        int res=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    res++;
                    dfs(i,j,n,m,grid);
                }
            }
        }
        return res;
    }
    private void dfs(int i,int j,int n,int m,int[][] grid){
        grid[i][j]=1;
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int k=0;k<dir.length;k++){
            int newi=dir[k][0]+i;
            int newj=dir[k][1]+j;
            if(isSafe(newi,newj,n,m) && grid[newi][newj]==0){
                dfs(newi,newj,n,m,grid);
            }
        }
    }
    private boolean isSafe(int i,int j,int n,int m){
        return (i>=0 && i<n && j>=0 && j<m);
    }
    public static void main(String[] args){
        int[][] grid ={{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        NumberOfClosedIslands numberOfClosedIslands = new NumberOfClosedIslands();
        System.out.println(numberOfClosedIslands.closedIsland(grid));
    }
}
