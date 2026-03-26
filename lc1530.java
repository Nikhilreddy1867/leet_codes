/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public int ans;
    public int dist;
    private  List<Integer> rec(TreeNode root){
        if(root==null) return new ArrayList<>();
        if(root.left==null && root.right==null){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            return temp;
        }
        List<Integer> left=rec(root.left);
        List<Integer> right=rec(root.right);
        for(int l:left){
            for(int r:right){
                if(l+r<=dist){
                    ans++;
                }
            }
        }
        List<Integer> curr=new ArrayList<>();
        for(int l:left){
            if(l+1<=dist) curr.add(l+1);
        }
        for(int r:right){
            if(r+1<=dist) curr.add(r+1);
        }
        return curr;
    }
    public int countPairs(TreeNode root, int distance) {
        ans=0;
        dist=distance;
        rec(root);
        return ans;
    }
}