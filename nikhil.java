//3567. Minimum Absolute Difference in Sliding Submatrix
class nikhil {
    private static int helper(List<Integer> arr){
        if(arr.size() <= 1) return 0;
        Collections.sort(arr);
        int min=Integer.MAX_VALUE;;
        for(int i=1;i<arr.size();i++){
            if(arr.get(i).equals(arr.get(i-1))) continue;
            min=Math.min(min,arr.get(i)-arr.get(i-1));
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ans=new int[(m - k + 1)][(n - k + 1)];
        for(int r1=0;r1<=m-k;r1++){
            for(int c1=0;c1<=n-k;c1++){
                // for(int r2=r1;r2<m;r2++){
                //     for(int c2=c1;c2<n;c2++){
                //         if(r2-r1+1==k && c2-c1+1==k){
                //             List<Integer> temp=new ArrayList<>();
                //             for(int i=r1;i<=r2;i++){
                //                 for(int j=c1;j<=c2;j++){
                //                     temp.add(grid[i][j]);
                //                 }
                //             }
                //             ans[r1][c1]=helper(temp);
                //         }
                //     }
                // }
                int r2=r1-1+k;
                int c2=c1-1+k;
                List<Integer> temp=new ArrayList<>();
                for(int i=r1;i<=r2;i++){
                    for(int j=c1;j<=c2;j++){
                        temp.add(grid[i][j]);
                    }
                }
                ans[r1][c1]=helper(temp);

            }
        }
        return ans;
    }
}
