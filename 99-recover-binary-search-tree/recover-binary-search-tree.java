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
    private TreeNode first=null;
    private TreeNode second=null;
    private TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        fix(root);
        if(first!=null && second!=null){
            swap(first,second);
        }
    }

    public void fix(TreeNode root){
        if(root==null) return;
        fix(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first=prev;
            }
            second=root;
        }
        prev=root;
        fix(root.right);
    }
    public void swap(TreeNode a, TreeNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
}
}