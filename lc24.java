class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[2];
        for(int k=0;k<n;k++){
            int i=k+1;
            int j=n-1;
            while(i<j){
                int currSum = nums[i] + nums[j] + nums[k]; 
                if(Math.abs(target-currSum)<Math.abs(target-sum)){
                    sum=currSum;
                }
                if(currSum<target){
                    i++;
                }
                else if(currSum>target){
                    j--;
                }
                else{
                    return target;
                }
            }
        }
        return sum;
    }
}