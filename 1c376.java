class Solution {
    private static int rec(int ind,int prev,int sign,Integer[][][] dp,int[] nums){
        int n=nums.length;
        if(ind==n) return 0;
        if(dp[ind][prev+1][sign]!=null){
            return dp[ind][prev+1][sign];
        }
        int notTake=rec(ind+1,prev,sign,dp,nums);
        int take=0;
        if(prev==-1){
            take=1+rec(ind+1,ind,2,dp,nums);
        }
        else{
            int diff=nums[ind]-nums[prev];
            if(diff>0 && sign!=1){
                take=1+rec(ind+1,ind,1,dp,nums);
            }
            else if(diff<0 && sign!=0){
                take=1+rec(ind+1,ind,0,dp,nums);
            }
        }
        return dp[ind][prev+1][sign]=Math.max(take,notTake);
    }
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        Integer[][][] dp=new Integer[n][n+1][3];
        return rec(0,-1,2,dp,nums);
    }
}