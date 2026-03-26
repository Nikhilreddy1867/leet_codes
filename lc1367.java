/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private static boolean check(TreeNode root,ListNode head){
        if(head==null) return true;
        if( root==null || head.val!=root.val) return false;
        if(check(root.left,head.next)){
            return true;
        }
        if(check(root.right,head.next)){
            return true;
        }
        return false;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        if(check(root,head)) return true;
        if(isSubPath(head,root.left)) return true;
        if(isSubPath(head,root.right)) return true;
        return false;
    }
}