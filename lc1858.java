class Node{
    Node links[]=new Node[26];
    boolean flag=false;
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void insert(char ch,Node node){
        links[ch-'a']=node;
    }
    public void end(){
        flag=true;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public boolean isEnd(){
        return flag==true;
    }
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.insert(ch,new Node());
            }
            node=node.get(ch);
        }
        node.end();
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node=node.get(ch);
        }
        if(node.flag==true){
            return true;
        }
        return false;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return true;
    }
    public boolean check(String s){
        Node node=root;
        boolean flag=true;
        for(int i=0;i<s.length() && flag;i++){
            if(node.containsKey(s.charAt(i))){
                node=node.get(s.charAt(i));
                flag=flag & node.isEnd();
            }
            else{
                return false;
            }
        }
        return flag;
    }
}
class Solution {
    public String longestValidWord(String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        String ans="";
        for(String word:words){
            if(trie.check(word)){
                if(word.length()>ans.length()){
                    ans=word;
                }
                else if(ans.length()==word.length() && word.compareTo(ans)<0){
                    ans=word;
                }
            }
        }
        return ans;
        
    }
}