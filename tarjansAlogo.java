class Solution {
    static int timer=1;
    private static void rec(int node,int parent, List<List<Integer>> adj,List<List<Integer>> ans,int[] tin,int[] vis,int[] low){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        for(int i=0;i<adj.get(node).size();i++){
            int n_node=adj.get(node).get(i);
            if(n_node==parent) continue;
            if(vis[n_node]==0){
                rec(n_node,node,adj,ans,tin,vis,low);
                low[node]=Math.min(low[node],low[n_node]);
                if(low[n_node]>tin[node]){
                    ans.add(new ArrayList<>(Arrays.asList(n_node,node)));
                }
            }
            else{
                low[node]=Math.min(low[node],tin[n_node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] vis=new int[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> arr:connections){
            int a=arr.get(0);
            int b=arr.get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        rec(0,-1,adj,ans,tin,vis,low);
        return ans;

    }
}