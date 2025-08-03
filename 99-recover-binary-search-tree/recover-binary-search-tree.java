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
    private TreeNode mid=null;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        prev=new TreeNode(Integer.MIN_VALUE);
        fix(root);
        if(first!=null && second!=null){
            int t=first.val;
            first.val=second.val;
            second.val=t;
        }else{
            int t=first.val;
            first.val=mid.val;
            mid.val=t;
        }
    }

    public void fix(TreeNode root){
        if(root==null) return;
        fix(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first=prev;
                mid=root;
            }else{
                second=root;
            }
        }
        prev=root;
        fix(root.right);
    }
}