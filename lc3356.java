class Solution {
    // private static boolean helper(int[] nums){
    //     for(int num:nums){
    //         if(num>0) return false;
    //     }
    //     return true;
    // }
    private static boolean helper(int[] nums,int[][] queries,int k){
        int n=nums.length;
        int[] diff=new int[n+1];
        for(int i=0;i<=k;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int inc=queries[i][2];
            diff[start]+=inc;
            if(end+1<n){
                diff[end+1]-=inc;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            diff[i]=sum;
            if(nums[i]-sum>0) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        boolean allZero = true;
        for (int x : nums) {
            if (x != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return 0;
        // for(int i=0;i<queries.length;i++){
        //     if(helper(nums,queries,i)){
        //         return i+1;
        //     }
        // }
        // return -1;
        int l=0;
        int r=queries.length-1;
        int k=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(helper(nums,queries,mid)){
                k=mid+1;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
        // int[] diff=new int[n+1];
        // for(int q=0;q<queries.length;q++){
        //     int start = queries[q][0];
        //     int end = queries[q][1];
        //     int inc = queries[q][2];
        //     diff[start]-=inc;
        //     diff[end+1]+=inc;
        //     int[] temp=new int[n];
        //     temp[0]=diff[0];
        //     for(int i=1;i<n;i++){
        //         temp[i]=temp[i-1]+diff[i];
        //     }
        //     int[] curr=new int[n];
        //     for(int i=0;i<n;i++){
        //         curr[i]=nums[i]+temp[i];
        //     }
        //     if(helper(curr)){
        //         return q+1;
        //     }
        // }
        // return -1;
    }
}