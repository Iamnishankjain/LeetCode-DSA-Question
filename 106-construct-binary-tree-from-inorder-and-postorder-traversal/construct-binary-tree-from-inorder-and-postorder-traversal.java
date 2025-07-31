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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root=build(postorder,postorder.length-1,0,inorder,0,inorder.length-1,map);
        return root;
    }

    public TreeNode build(int[] postorder,int postSt,int postEnd, int[] inorder,int inSt,int inEnd,HashMap<Integer,Integer> map){
        if(postSt<postEnd || inSt>inEnd) return null;

        TreeNode root=new TreeNode(postorder[postSt]);
        int indRoot=map.get(root.val);
        int numRight=inEnd-indRoot;
        root.right=build(postorder,postSt-1,postEnd-numRight,inorder,indRoot+1,inEnd,map);
        root.left=build(postorder,postSt-numRight-1,postEnd,inorder,inSt,indRoot-1,map);
        return root;
    }
}