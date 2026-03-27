class lc1639 {
    public int MOD = 1000000007;
    private  int rec(int ind,int k,String target,String[] words,Integer[][] dp,List<HashMap<Character,Integer>> arr){
        if(ind==target.length()) return 1;
        if(k==words[0].length()) return 0;
        if(dp[ind][k]!=null) return dp[ind][k];
        long take=0;
        int notTake=0;
        notTake=rec(ind,k+1,target,words,dp,arr)%MOD;
        // for(int i=0;i<words.length;i++){
        //     if(words[i].charAt(k)==target.charAt(ind)){
        //         take=(take+rec(ind+1,k+1,target,words,dp))%MOD;
        //     }
        // }
        Map<Character, Integer> map = arr.get(k);
        char ch = target.charAt(ind);
        if (map.containsKey(ch)) {
            int count = map.get(ch);
            take=(take+(long) count*rec(ind+1,k+1,target,words,dp,arr))%MOD;
        }

        return dp[ind][k]=(int)(take+notTake)%MOD;
    }
    public int numWays(String[] words, String target) {
        int n=target.length();
        int m=words[0].length();
        List<HashMap<Character,Integer>> arr=new ArrayList<>();
        for(int i=0;i<m;i++){
            arr.add(new HashMap<>());
        }
        for(String word:words){
            for(int i=0;i<m;i++){
                char ch=word.charAt(i);
                Map<Character,Integer> temp=arr.get(i);
                temp.put(ch,temp.getOrDefault(ch,0)+1);
            }
        }
        Integer[][] dp=new Integer[n][m];
        return rec(0,0,target,words,dp,arr);
    }
}