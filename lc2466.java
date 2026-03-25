class Solution {
    private static int rec(int ind,int[] dp,int low,int high,int zero,int one){
        if(ind>high) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int curr=0;
        if(ind>=low && ind<=high){
            curr=1;
        }
        int tone=rec(ind+one,dp,low,high,zero,one);
        int tzero=rec(ind+zero,dp,low,high,zero,one);
        return dp[ind]=(curr+tone+tzero)%1_000_000_007;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp=new int[high+1];
        Arrays.fill(dp,-1);
        return rec(0,dp,low,high,zero,one);
    }
}