class Solution {
    private static void dfs(int node,Stack<Integer> st,List<List<Integer>> adj,int[] vis){
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int n_node=adj.get(node).get(i);
            if(vis[n_node]==0){
                dfs(n_node,st,adj,vis);
            }
        }
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int[] vis=new int[V];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr:edges){
            int a=arr[0];
            int b=arr[1];
            adj.get(a).add(b);
        }
        //dfs logic
        // Stack<Integer> st=new Stack<>();
        // for(int i=0;i<V;i++){
        //     if(vis[i]==0){
        //         dfs(i,st,adj,vis);
        //     }
        // }
        // ArrayList<Integer> ans=new ArrayList<>();
        // while(!st.isEmpty()){
        //     ans.add(st.peek());
        //     st.pop();
        // }
        // return ans;
        //kahn algorithm
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
        return ans;
    }
}