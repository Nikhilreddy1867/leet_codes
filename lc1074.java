class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] prefix=new int[m][n];
        prefix[0][0]=matrix[0][0];
        for(int i=1;i<m;i++){
            prefix[i][0]=prefix[i-1][0]+matrix[i][0];
        }
        for(int j=1;j<n;j++){
            prefix[0][j]=prefix[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                prefix[i][j]=matrix[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
            }
        }
        int ans=0;
        for(int r1=0;r1<m;r1++){
            for(int r2=r1;r2<m;r2++){
                for(int c1=0;c1<n;c1++){
                    for(int c2=c1;c2<n;c2++){
                        int sum = prefix[r2][c2];
                        if(r1>0) sum-=prefix[r1-1][c2];
                        if(c1>0) sum-=prefix[r2][c1-1];
                        if(r1>0 && c1>0) sum+=prefix[r1-1][c1-1];
                        if(sum==target) ans++;
                    }
                }
            }
        }
        return ans;
    }
}