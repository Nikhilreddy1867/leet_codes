class Solution {
    private static void rec(int ind,List<String> temp,List<List<String>> ans,String s,HashSet<String> hs){
        if(ind==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(!hs.contains(s.substring(ind,i+1))){
                hs.add(s.substring(ind,i+1));
                temp.add(s.substring(ind,i+1));
                rec(i+1,temp,ans,s,hs);
                hs.remove(s.substring(ind,i+1));
                temp.remove(temp.size()-1);
            }
        }
    }
    public int maxUniqueSplit(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> temp =new ArrayList<>();
        HashSet<String> hs=new HashSet<>();
        rec(0,temp,ans,s,hs);
        int max=0;
        for(List<String> l:ans){
            max=Math.max(max,l.size());
        }
        return max;
    }
}