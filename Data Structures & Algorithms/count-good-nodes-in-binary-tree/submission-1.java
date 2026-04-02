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
    public class State {
        TreeNode node;
        int maxValue;
        public State(TreeNode node, int maxValue) {
            this.maxValue = maxValue;
            this.node = node;
        }
    }
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<State> q = new LinkedList<>();
        q.add(new State(root, root.val));

        int answer = 0;

        while(!q.isEmpty()) {
          State curr =  q.poll();
          int newMax = Math.max(curr.node.val, curr.maxValue);

          if(curr.node.val >= curr.maxValue) {
                answer++;
          }
          if(curr.node.left != null) {
            q.add(new State(curr.node.left, newMax));
          }
          if(curr.node.right != null) {
            q.add(new State(curr.node.right, newMax));
          }
        }
        return answer;
    }
}
