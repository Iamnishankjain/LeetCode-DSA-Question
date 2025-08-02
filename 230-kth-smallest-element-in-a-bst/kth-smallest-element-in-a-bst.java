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
    public int kthSmallest(TreeNode root, int k) {
        int arr[]=new int[1];
        int data=get(root,k,arr);
        return data;
    }
    public int get(TreeNode root,int k,int[] c){
        if(root==null) return -1;
        int l=get(root.left,k,c);
        if(l!=-1) return l;
        c[0]++;
        if(c[0]==k) return root.val;
        int r=get(root.right,k,c);
        
        return r;
    }
}