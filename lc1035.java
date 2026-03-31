class Solution {
    private static int rec(int ind1,int ind2,Integer[][] dp,int[] nums1,int[] nums2){
        if(ind1==nums1.length || ind2==nums2.length){
            return 0;
        }
        if(dp[ind1][ind2]!=null) return dp[ind1][ind2];
        int take=0;
        int notTake=0;
        if(nums1[ind1]==nums2[ind2]){
            take=1+rec(ind1+1,ind2+1,dp,nums1,nums2);
        }
        else{
            notTake=Math.max(rec(ind1+1,ind2,dp,nums1,nums2),rec(ind1,ind2+1,dp,nums1,nums2));
        }
        return dp[ind1][ind2]=take+notTake;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Integer[][] dp=new Integer[n+1][m+1];
        return rec(0,0,dp,nums1,nums2);
    }
}