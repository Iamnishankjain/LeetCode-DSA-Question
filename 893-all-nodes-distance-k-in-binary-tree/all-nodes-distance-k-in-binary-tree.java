/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        getParent(root,parent);
        List<TreeNode> visited=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        visited.add(target);
        q.offer(target);
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(dist==k) break;
            dist++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                if(parent.get(curr)!=null && !visited.contains(parent.get(curr))){
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        return list;
    }

    public void getParent(TreeNode root,Map<TreeNode,TreeNode> parent){
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        parent.put(root,null);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
}