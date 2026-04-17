class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        if(!hs.contains(endWord)) return 0;
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)) return level;
                char[] temp=word.toCharArray();
                for(int j=0;j<temp.length;j++){
                    char original=temp[j];
                    for(char ch='a';ch<='z';ch++){
                        temp[j]=ch;
                        String s=new String(temp);
                        if(hs.contains(s)){
                            q.offer(s);
                            hs.remove(s);
                        }
                    }
                    temp[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}