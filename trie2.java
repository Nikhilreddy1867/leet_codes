import java.util.* ;
import java.io.*;
class Node{
    Node[] links=new Node[26];
    int prefix=0;
    int end=0;
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void insert(char ch,Node node){
        links[ch-'a']=node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void incresePrefix(){
        prefix++;
    }
    public void decreasePrefix(){
        prefix--;
    }
    public void increaseEnd(){
        end++;
    }
    public void decreaseEnd(){
        end--;
    }

}
public class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                node.insert(ch,new Node());
            }
            node=node.get(ch);
            node.incresePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.end;
    }

    public int countWordsStartingWith(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.prefix;
    }

    public void erase(String word) {
        Node node=root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return;
            }
            node=node.get(ch);
            node.decreasePrefix();
        }
        node.decreaseEnd();
    }

}
