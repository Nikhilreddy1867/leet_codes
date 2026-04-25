class Solution {
    static int timer=0;
    private static void rec(int node,int parent,int[] mark,int[] low,int[] vis,int[] tin,List<List<Integer>> adj){ 
        vis[node]=1;
        tin[node]=low[node]=timer++;
        int child=0;
        for(int i=0;i<adj.get(node).size();i++){
            int n_node=adj.get(node).get(i);
            if(n_node==parent) continue;
            if(vis[n_node]==0){
                rec(n_node,node,mark,low,vis,tin,adj);
                low[node]=Math.min(low[node],low[n_node]);
                if(low[n_node]>=tin[node] && parent!=-1){
                    mark[node]=1;
                }
                child++;
            }
            else{
                low[node]=Math.min(low[node],tin[n_node]);
            }
        }
        if(child>1 && parent==-1){
            mark[node]=1;
        }
    }
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            int a=arr[0];
            int b=arr[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] mark=new int[V];
        int[] vis=new int[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                rec(i,-1,mark,low,vis,tin,adj);
            }
        }
        for(int i=0;i<V;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        if(ans.size()!=0) return ans;
        return new ArrayList<>(Arrays.asList(-1));
    }
    
}