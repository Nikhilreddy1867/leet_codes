class DSU{
    int[] rank;
    int[] par;
    DSU(int n){
        rank=new int[n];
        par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=1;
        }   
    }
    int findPar(int i){
            if(par[i]!=i){
                par[i]=findPar(par[i]);
            }
            return par[i];
        }
        void unionByRank(int u,int v){
            int u_p=findPar(u);
            int v_p=findPar(v);
            if(u_p==v_p) return;
            else if(rank[u_p]>rank[v_p]){
                 par[v_p]=u_p;
            }
            else if(rank[v_p]>rank[u_p]){
                par[u_p]=v_p;
            }
            else{
                rank[v_p]++;
                par[u_p]=v_p;
            }
        }
}
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        HashMap<Integer,HashMap<Integer,Integer>> hs=new HashMap<>();
        DSU dsu=new DSU(n);
        for(int[] arr:allowedSwaps){
            dsu.unionByRank(arr[0],arr[1]);
        }
        for(int i=0;i<n;i++){
            int val=dsu.findPar(i);
            if(!hs.containsKey(val)){
                hs.put(val,new HashMap<>());
            }
            hs.get(val).put(source[i], hs.get(val).getOrDefault(source[i],0)+1);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int root=dsu.findPar(i);
            if(hs.get(root).getOrDefault(target[i],0)>0){
                hs.get(root).put(target[i],hs.get(root).get(target[i])-1);
            }
            else{
                ans++;
            }
        }
        return ans;
    }
}