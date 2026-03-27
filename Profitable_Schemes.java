class Profitable_Schemes {
    int MOD = 1000000007;
    private  int rec(int ind,int mem,int profit1,int[] group,int[] profit,int minProfit,Integer[][][] dp,int n){
        if(ind==group.length){
            if(profit1>=minProfit) return 1;
            return 0;
        }
        if(dp[ind][mem][profit1]!=null) return dp[ind][mem][profit1];
        long notTake=(rec(ind+1,mem,profit1,group,profit,minProfit,dp,n))%MOD;
        long take=0;
        if(mem+group[ind]<=n){
            int n_profit=Math.min(minProfit,profit1+profit[ind]);
            take=(take+rec(ind+1,mem+group[ind],n_profit,group,profit,minProfit,dp,n))%MOD;
        }
        return dp[ind][mem][profit1]=(int)((take+notTake)%MOD);
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m=group.length;
        Integer[][][] dp=new Integer[m+1][n+1][minProfit+1];
        return rec(0,0,0,group,profit,minProfit,dp,n);
    }
}