class Solution {
    private int count=0;
    private void rec(int ind,HashMap<Integer,Integer> hs,int[] nums,int k){
        if(ind==nums.length){
            if(hs.size()>0) count++;
            return;
        }
        if(!hs.containsKey(nums[ind]-k)){
            hs.put(nums[ind],hs.getOrDefault(nums[ind],0)+1);
            rec(ind+1,hs,nums,k);
            hs.put(nums[ind],hs.get(nums[ind])-1);
            if(hs.get(nums[ind])==0) hs.remove(nums[ind]);
        }
        rec(ind+1,hs,nums,k);

    }
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums); 
        HashMap<Integer,Integer> used=new HashMap<>();
        HashSet<List<Integer>>  ans=new HashSet<>();
        rec(0,used,nums,k);
        return count;
    }
}