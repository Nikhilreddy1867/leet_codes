class Solution {
    private static int rec(int l,int r,Integer[][] dp,String s,int n){
        if(l==r) return 1;
        if(l>r) return 0;
        if(dp[l][r]!=null) return dp[l][r];
        int i=l+1;
        while(i<r && s.charAt(i)==s.charAt(l)){
            i++;
        }
        if(i>r) return dp[l][r]=1;
        int basic=1+rec(i,r,dp,s,n);
        int lalach=Integer.MAX_VALUE;
        for(int j=i;j<=r;j++){
            if(s.charAt(j)==s.charAt(l)){
                int temp=rec(i,j-1,dp,s,n)+rec(j,r,dp,s,n);
                lalach=Math.min(lalach,temp);
            }
        }
        return dp[l][r]=Math.min(basic,lalach);
    }
    public int strangePrinter(String s) {
        int n=s.length();
        Integer[][] dp=new Integer[n+1][n+1];
        return rec(0,n-1,dp,s,n);
    }
}