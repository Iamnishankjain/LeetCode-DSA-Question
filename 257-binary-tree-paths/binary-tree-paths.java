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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<>();
        if(root==null) return list;
        get(root,list,"");
        return list;
    }

    public void get(TreeNode root,List<String> list,String s){
        if(root.left==null && root.right==null){
            s+=""+root.val;
            list.add(s);
            return;
        }
        s+=""+root.val+"->";
        if(root.left!=null) get(root.left,list,s); 
        if(root.right!=null) get(root.right,list,s); 
    }
}