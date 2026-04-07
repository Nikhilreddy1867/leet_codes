class triplet{
    int row;
    int col;
    int t;
    triplet(int row,int col,int t){
        this.row=row;
        this.col=col;
        this.t=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<triplet> q=new LinkedList<>();
        int[][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new triplet(i,j,0));
                    vis[i][j]=2;
                }
            }
        }
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        int ans=0;
        while(!q.isEmpty()){
            triplet temp=q.poll();
            int row=temp.row;
            int col=temp.col;
            int time=temp.t;
            ans=Math.max(ans,time);
            for(int k=0;k<4;k++){
                int n_row=row+delRow[k];
                int n_col=col+delCol[k];
                if(n_row>=0 && n_row<m && n_col>=0 && n_col<n && grid[n_row][n_col]==1 && vis[n_row][n_col]==0){
                    q.offer(new triplet(n_row,n_col,time+1));
                    vis[n_row][n_col]=2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]!=2){
                    return -1;
                }
            }
        }
        return ans;
    }
}