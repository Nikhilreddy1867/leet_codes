class Solution {
    private static int rec(int ind,int last,String s,int[][] dp,int n){
        if(ind==n) return 0;
        if(dp[ind][last]!=-1) return dp[ind][last];
        int flip=Integer.MAX_VALUE;
        int nonFlip=Integer.MAX_VALUE;
        if(s.charAt(ind)=='0'){
            if(last==0){
                flip=1+rec(ind+1,1,s,dp,n);
                nonFlip=0+rec(ind+1,0,s,dp,n);
            }
            else{
                flip=1+rec(ind+1,1,s,dp,n);
            }
        }
        else{
            if(last==0){
                flip=1+rec(ind+1,0,s,dp,n);
                nonFlip=0+rec(ind+1,1,s,dp,n);
            }
            else{
                nonFlip=0+rec(ind+1,1,s,dp,n);
            }
        }
        return dp[ind][last]=Math.min(flip,nonFlip);
    }
    public int minFlipsMonoIncr(String s) {
        int n=s.length();
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(0,0,s,dp,n);
    }
}