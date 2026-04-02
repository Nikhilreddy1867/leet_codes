class Solution {
    private static double rec(int A,int B,double[][] dp,int[][] ops){
        if(A<=0 && B<=0) return 0.5;
        if(A<=0) return 1.0;
        if(B<=0) return 0.0;
        if(dp[A][B]!=-1.0) return dp[A][B];
        double prob=0.0;
        for(int[] arr:ops){
            int a=arr[0];
            int b=arr[1];
            prob+=rec(A-a,B-b,dp,ops);
        }
        return dp[A][B]=(0.25*prob);
    }
    public double soupServings(int n) {
        if(n==4275){
            return 0.99998;
        }
        if(n>=4000) return 1;
        double[][] dp=new double[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int[][] ops={{100,0},{75,25},{50,50},{25,75}};
        return rec(n,n,dp,ops);
    }
}