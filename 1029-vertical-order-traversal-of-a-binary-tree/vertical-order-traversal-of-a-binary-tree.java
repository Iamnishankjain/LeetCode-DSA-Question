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
class Pair{
    TreeNode node;
    int x,level;
    Pair(TreeNode node,int x,int level){
        this.node=node;
        this.x=x;
        this.level=level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            TreeNode currNode=curr.node;
            int v=curr.x;
            int l=curr.level;

            if(!map.containsKey(v)){
                map.put(v,new TreeMap<>());
            }
            if(!map.get(v).containsKey(l)){
                map.get(v).put(l,new PriorityQueue<>());
            }
            map.get(v).get(l).offer(currNode.val);
            if(currNode.left!=null) q.offer(new Pair(currNode.left,v-1,l+1));
            if(currNode.right!=null) q.offer(new Pair(currNode.right,v+1,l+1));
        }


        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> outerEntry: map.entrySet()){
            List<Integer> col=new ArrayList<>();
            TreeMap<Integer,PriorityQueue<Integer>> innerMap=outerEntry.getValue();
            for(Map.Entry<Integer,PriorityQueue<Integer>> innerEntry: innerMap.entrySet()){
                PriorityQueue<Integer> pq=innerEntry.getValue();
                while(!pq.isEmpty()) col.add(pq.poll());
            }
            ans.add(col);
        }
        return ans;
    }
}