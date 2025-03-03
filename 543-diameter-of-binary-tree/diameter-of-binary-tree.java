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
    public class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeInfo tree=diameter(root);
        return tree.diam;
    }

    public TreeInfo diameter(TreeNode root){
        if(root==null){
            return new TreeInfo(0,0);
        }
        TreeInfo left=diameter(root.left);
        TreeInfo right=diameter(root.right);
        int height=Math.max(left.ht,right.ht)+1;

        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.ht+right.ht;
        int diam=Math.max(diam1,Math.max(diam2,diam3));
        TreeInfo tree=new TreeInfo(height,diam);
        return tree;        
    }
}