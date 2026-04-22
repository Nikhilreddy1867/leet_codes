class Solution {
    private static boolean helper(String s1,String s2){
        int diff=0; 
        for(int i=0;i<s1.length();i++){ 
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++; 
            }
            if(diff>2) return false; 
        }
        return true; 
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int m=queries.length;
        int n=dictionary.length;
        List<String> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(queries[i],dictionary[j])){
                    ans.add(queries[i]);
                    break;
                }
            }
        }
        return ans;
    }
}