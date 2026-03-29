class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum;
                if(i>0){
                    sum=prefix[j]-prefix[i-1];
                }
                else{
                    sum=prefix[j];
                }
                if(sum==k) ans++;
            }
        }
        return ans;
    }
}