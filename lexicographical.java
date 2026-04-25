import java.util.*;
class DSU{
    int[] parent;
    DSU(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    void union(int u,int v){
        int pu=findPar(u);
        int pv=findPar(v);
        if(pu==pv) return;
        if(pu<pv){
            parent[pv]=pu;
        }
        else{
            parent[pu]=pv;
        }
    }
    int findPar(int i){
        if(parent[i]==i) return parent[i];
        return parent[i]=findPar(parent[i]);
    }
}

class lexicographical {
    static String helper(String word1,String word2,String target){
        DSU dsu=new DSU(26);
        for(int i=0;i<word1.length();i++){
            char ch1=word1.charAt(i);
            char ch2=word2.charAt(i);
            dsu.union(ch1-'a',ch2-'a');
        }
        String ans="";
        for(int i=0;i<target.length();i++){
            int idx=target.charAt(i)-'a';
            char par=(char)(dsu.findPar(idx)+'a');
            ans+=par;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String 1");
        String str1=sc.next();
        System.out.println("Enter String 2");
        String str2=sc.next();
        System.out.println("Enter target");
        String target=sc.next();
        System.out.println("lexicographically smallest equivalnet substring is:");
        System.out.println(helper(str1,str2,target));
    }
}
