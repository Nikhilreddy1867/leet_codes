class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[] vis=new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            int a=i;
            for(int j=0;j<graph[i].length;j++){
                int b=graph[i][j];
                adj.get(b).add(a);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int[] in=new int[V];
        for(List<Integer> arr:adj){
            for(int node:arr){
                in[node]++;
            }
        }
        for(int i =0;i<in.length;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
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
        Collections.sort(ans);
        return ans;
    }
}