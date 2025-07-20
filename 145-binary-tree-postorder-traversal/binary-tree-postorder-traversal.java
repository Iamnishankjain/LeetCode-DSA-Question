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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode p=st1.pop();
            st2.push(p.val);
            if(p.left!=null) st1.push(p.left);
            if(p.right!=null) st1.push(p.right);
        }
        while(!st2.isEmpty()){
            res.add(st2.pop());
        }
        return res;
    }
}