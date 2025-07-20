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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        int flag=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<level;i++){
                TreeNode front=q.remove();
                if(flag==1){
                    list.add(0,front.val);
                }
                else{
                    list.add(front.val);
                }

                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            flag= flag==0 ? 1: 0;
            res.add(list);
        }
        return res;
    }
}