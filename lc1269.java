class Solution {
    public int mod=1000000007;
    private  int rec(int ind,int steps,int arrLen,Integer[][] dp){
        if(steps==0){
            if(ind==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        if(dp[ind][steps]!=null) return dp[ind][steps];
        int stay=rec(ind,steps-1,arrLen,dp);
        int right=0;
        int left=0;
        if(ind+1<arrLen){
            right=rec(ind+1,steps-1,arrLen,dp);
        }
        if(ind-1>=0){
            left=rec(ind-1,steps-1,arrLen,dp);
        }
        return dp[ind][steps]=((right+left)%mod+stay)%mod;
    }
    public int numWays(int steps, int arrLen) {
        arrLen=Math.min(arrLen,steps);
        Integer[][] dp=new Integer[arrLen+1][steps+1];
        return rec(0,steps,arrLen,dp);
    }
}