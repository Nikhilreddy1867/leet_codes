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
class Solution {
    private static TreeNode lowestCommonAncestor(TreeNode root, int p, int q){
        if(root==null){
            return null;
        }
        if(root.val==p) return root;
        if(root.val==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null) return left;
        else{
            return right;
        }
    }
    private static boolean helper(TreeNode root,int target,StringBuilder sb){
        if(root==null) return false;
        if(target==root.val) return true;
        sb.append('L');
        if(helper(root.left,target,sb)){
            return true;
        }
        sb.setLength(sb.length()-1);
        sb.append('R');
        if(helper(root.right,target,sb)){
            return true;
        }
        sb.setLength(sb.length()-1);
        return false;
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca=lowestCommonAncestor(root,startValue,destValue);
        StringBuilder result = new StringBuilder();
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        helper(lca,startValue,sb);
        helper(lca,destValue,sb1);
        for(int i=0;i<sb.length();i++){
            result.append('U');
        }
        result.append(sb1);
        return result.toString();
    }
}