class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            rank[i]=1;
            parent[i]=i;
        }
    }
    int findPar(int x){
        if(parent[x]!=x){
            parent[x]=findPar(parent[x]);
        }
        return parent[x];
    }
    void unionByRank(int u,int v){
        int u_p=findPar(u);
        int v_p=findPar(v);
        if(u_p==v_p) return ;
        else{
            if(rank[u_p]>rank[v_p]){
                parent[v_p]=u_p;
            }
            else if(rank[u_p]<rank[v_p]){
                parent[u_p]=v_p;
            }
            else{
                parent[u_p]=v_p;
                rank[v_p]++;
            }
        }
    }
}
class Solution {
    private static boolean check(int mid,int n,int[][] edges,int k){
        DSU dsu=new DSU(n);
        List<int[]> candidates=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            int s=edges[i][2];
            int m=edges[i][3];
            if(m==1){
                if(s<mid) return false;
                dsu.unionByRank(a,b);
            }
            else{
                if(s>=mid){
                    dsu.unionByRank(a,b);
                }
                else if(2*s>=mid){
                    candidates.add(new int[]{a,b});
                }
            }
        }
        for(int[] arr:candidates){
            int u=arr[0];
            int v=arr[1];
            if(dsu.findPar(u)!=dsu.findPar(v)){
                if(k<=0){
                    return false;
                }
                dsu.unionByRank(u,v);
                k--;
            }
        }
        int root=dsu.findPar(0);
        for(int node=1;node<n;node++){
            if(dsu.findPar(node)!=root) return false;
        }
        return true;
    }
    public int maxStability(int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u=edge[0];
            int v=edge[1];
            int m=edge[3];

            if (m==1) {
                if(dsu.findPar(u)==dsu.findPar(v)) {
                    return -1;
                }
                dsu.unionByRank(u, v);
            }
        }
        int ans=-1;
        int l=1;
        int r=(int)2e5;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(check(mid,n,edges,k)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
}