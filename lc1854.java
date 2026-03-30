class Solution {
    public int maximumPopulation(int[][] logs) {
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<logs.length;i++){
            int a=logs[i][0];
            int b =logs[i][1];
            ans.add(new int[]{a,1});
            ans.add(new int[]{b,-1});
        }
        Collections.sort(ans,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int year=0;
        int curr=0;
        int ans1=0;
        for(int[] arr:ans){
            if(arr[1]==1){
                curr++;
                if(curr>ans1){
                    ans1=curr;
                    year=arr[0];
                }
            }
            else{
                curr--;
            }
        }
        return year;
    }
}