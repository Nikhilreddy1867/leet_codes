class Solution {
    private static int rec(int l,int r,Integer[][] dp){
        if(l>=r) return 0;
        if(dp[l][r]!=null) return dp[l][r];
        int min=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int cost=i+Math.max(rec(l,i-1,dp),rec(i+1,r,dp));
            min=Math.min(min,cost);
        }
        return dp[l][r]=min;
    }
    public int getMoneyAmount(int n) {
        Integer[][] dp=new Integer[n+1][n+1];
        return rec(0,n,dp);
    }
}