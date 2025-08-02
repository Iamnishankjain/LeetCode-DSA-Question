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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0) return null;
        int i=0;
        TreeNode root=new TreeNode(preorder[i++]);
        
        while(i<preorder.length){
            TreeNode curr=root;
            TreeNode newNode=new TreeNode(preorder[i]);;
            while(true){
                if(curr.val>preorder[i]){
                    if(curr.left==null) {
                        curr.left=newNode;
                        break;
                    }
                else curr=curr.left;
            }else if(curr.val<preorder[i]){
                if(curr.right==null) {
                    curr.right=newNode;
                    break;
                }
                else curr=curr.right;
            }
            }i++;
        }
        return root;
    }
}