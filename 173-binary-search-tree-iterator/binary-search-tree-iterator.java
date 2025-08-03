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
class BSTIterator {
    Stack<TreeNode> s=new Stack<>();
    public BSTIterator(TreeNode root) {
        if(root==null) return;
        while(root!=null){
            s.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        if(s.isEmpty()) return -1;
        TreeNode top=s.pop();
        TreeNode right=top.right;
        if(right!=null){
            s.push(right);
            while(right.left!=null){
                s.push(right.left);
                right=right.left;
            } 
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */