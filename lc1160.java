class Solution {
    private static boolean helper(String s,HashMap<Character,Integer> hs){
        HashMap<Character,Integer> hs1=new HashMap<>();
        for(char c:s.toCharArray()){
            hs1.put(c,hs1.getOrDefault(c,0)+1);
        }
        for(char ch:hs1.keySet()){
            int val=hs1.get(ch);
            if(!hs.containsKey(ch)) return false;
            else{
                int val1=hs.get(ch);
                if(val1<val) return false;
            }
        }
        return true;
    }
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> hs=new HashMap<>();
        for(char c:chars.toCharArray()){
            hs.put(c,hs.getOrDefault(c,0)+1);
        }
        int ans=0;
        for(String s:words){
            if(helper(s,hs)){
                ans+=s.length();
            }
        }
        return ans;
    }
}