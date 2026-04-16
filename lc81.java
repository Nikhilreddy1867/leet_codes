class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return true;
            }
            if (nums[l]==nums[mid] && nums[mid]==nums[r]) {
                l++;
                r--;
                continue;
            }
            if(nums[l]<=nums[mid]){
                if(target>=nums[l] && target<=nums[mid]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(target<=nums[r] && target>nums[mid]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}