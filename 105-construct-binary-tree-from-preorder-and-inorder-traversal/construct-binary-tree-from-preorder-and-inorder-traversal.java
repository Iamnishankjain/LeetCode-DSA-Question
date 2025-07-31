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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root=build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public TreeNode build(int[] preorder,int preSt,int preEnd, int[] inorder,int inSt,int inEnd,HashMap<Integer,Integer> map){
        if(preSt>preEnd || inSt>inEnd) return null;

        TreeNode root=new TreeNode(preorder[preSt]);
        int indRoot=map.get(root.val);
        int indLeft=indRoot-inSt;
        root.left=build(preorder,preSt+1,indLeft+preSt,inorder,inSt,indRoot-1,map);
        root.right=build(preorder,preSt+indLeft+1,preEnd,inorder,indRoot+1,inEnd,map);
        return root;
    }
}