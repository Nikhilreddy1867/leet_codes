class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites){
            int a=arr[0];
            int b=arr[1];
            adj.get(b).add(a);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] in=new int[numCourses];
        for(List<Integer> arr:adj){
            for(int num:arr){
                in[num]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                in[adj.get(node).get(i)]--;
                if(in[adj.get(node).get(i)]==0){
                    q.offer(adj.get(node).get(i));
                }
            }
        }
        if(ans.size()==numCourses) return true;
        return false;
    }
}