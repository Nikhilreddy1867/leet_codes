class Solution {
    int MOD = 1000000007;
    private int rec(int ind,Integer[] dp,String s,int k,int n){
        if(ind>=n) return 1;
        if(dp[ind]!=null) return dp[ind];
        long ways=0;
        if(s.charAt(ind)=='0') return dp[ind]=0;
        long num=0;
        for(int i=ind;i<n;i++){
            num=num*10+(s.charAt(i)-'0');
            if(num>k) break;
            ways=(ways+rec(i+1,dp,s,k,n))%MOD;
        }
        return dp[ind]=(int)(ways);
    }
    public int numberOfArrays(String s, int k) {
        int n=s.length();
        Integer[] dp=new Integer[n+1];
        return rec(0,dp,s,k,n);
    }
}