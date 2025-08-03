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
    Stack<TreeNode> s1=new Stack<>();
    Stack<TreeNode> s2=new Stack<>();
    public boolean findTarget(TreeNode root, int k) {
        bstIterator(root,root);
        int a=next();
        int b=before();
        while(a<b){
            if(a+b==k) return true;
            else if(a+b>k) b=before();
            else a=next();
        }
        return false;
    }
    void bstIterator(TreeNode r1,TreeNode r2){
        while(r1!=null){
            s1.push(r1);
            r1=r1.left;
        }
        while(r2!=null){
            s2.push(r2);
            r2=r2.right;
        }
    }
    int next(){
        if(s1.isEmpty()) return -1;
        TreeNode top=s1.pop();
        TreeNode right=top.right;
        while(right!=null){
            s1.push(right);
            right=right.left;
        }
        return top.val;
    }
    int before(){
        if(s2.isEmpty()) return -1;
        TreeNode top=s2.pop();
        TreeNode left=top.left;
        while(left!=null){
            s2.push(left);
            left=left.right;
        }
        return top.val;
    }
}