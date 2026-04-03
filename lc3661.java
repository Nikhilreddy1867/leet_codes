class pair{
    int first;
    int second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    private static int lowerBound(int[] arr, int target) {
        int l=0;
        int r=arr.length;
        while(l<r) {
            int mid =l+(r-l)/2;
            if (arr[mid]>=target) {
                r=mid;
            }
            else {
                l=mid+1;
            }
        }
        return l;
    }
    private static int upperBound(int[] arr, int target) {
        int l=0;
        int r=arr.length;
        while (l<r) {
            int mid =l+(r-l)/2;
            if (arr[mid]>target) {
                r=mid;
            }
            else {
                l=mid+1;
            }
        }
        return l;
    }
    private static int helper(int[] walls,int l,int r){
        int left=lowerBound(walls,l);
        int right=upperBound(walls,r);
        return right - left;
    }
    private static int rec(int ind,int[] walls,int[][] range,int[][] dist,int dir,Integer[][] dp,int n){
        if(ind==n){
            return 0;
        }
        if(dp[ind][dir]!=null) return dp[ind][dir];
        int leftRange=range[ind][0];
        if(dir==1 && ind>0){
            leftRange=Math.max(leftRange,range[ind-1][1]+1);
        }
        int left=helper(walls,leftRange,dist[ind][0])+rec(ind+1,walls,range,dist,0,dp,n);
        int right=helper(walls,dist[ind][0],range[ind][1])+rec(ind+1,walls,range,dist,1,dp,n);
        return dp[ind][dir]=Math.max(left,right);
    }
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n=robots.length;
        int[][] dis=new int[n][2];
        for(int i=0;i<n;i++){
            dis[i][0]=robots[i];
            dis[i][1]=distance[i];
        }
        Arrays.sort(dis,(a,b)->a[0]-b[0]);
        Arrays.sort(walls);
        int[][] range=new int[n][2];
        for(int i=0;i<n;i++){
            int leftRange=dis[i][0]-dis[i][1];
            int rightRange=dis[i][0]+dis[i][1];
            int tempLeft=Integer.MIN_VALUE;
            int tempRight=Integer.MAX_VALUE;
            if(i>0){
                tempLeft=dis[i-1][0]+1;
            }
            if(i<n-1){
                tempRight=dis[i+1][0]-1;
            }
            range[i][0]=Math.max(leftRange,tempLeft);
            range[i][1]=Math.min(rightRange,tempRight);
        }
        Integer[][] dp=new Integer[n][2];
        return rec(0,walls,range,dis,0,dp,n);
    }
}