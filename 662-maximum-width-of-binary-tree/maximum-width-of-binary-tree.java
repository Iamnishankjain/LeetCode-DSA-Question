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
public class Pair{
    int ind;
    TreeNode node;
    Pair(TreeNode node,int ind){
        this.ind=ind;
        this.node=node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int width=0;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int level=q.size();
            int first=0,last=0;
            for(int i=0;i<level;i++){
                Pair pair=q.poll();
                int currInd=pair.ind-1;
                TreeNode node=pair.node;
                if(i==0) first=currInd;
                if(i==level-1) last=currInd;
                if(node.left!=null) q.offer(new Pair(node.left,2*currInd+1));
                if(node.right!=null) q.offer(new Pair(node.right,2*currInd+2));
            }
            width=Math.max(width,last-first+1);
        }
        return width;
    }
}