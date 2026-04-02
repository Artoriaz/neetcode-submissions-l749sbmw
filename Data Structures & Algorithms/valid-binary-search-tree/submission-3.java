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
        long max;
        long min;
        public State(TreeNode node, long min , long max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        Queue<State> q = new LinkedList<>();
        q.add(new State(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while(!q.isEmpty()) {
            State curr = q.poll();
            TreeNode node = curr.node;

            if(!(node.val > curr.min && node.val < curr.max)) {
                return false;
            }

            if(node.left != null) {
                q.offer(new State(node.left, curr.min, node.val));
            }
            if(node.right != null) {
                q.offer(new State(node.right, node.val, curr.max));
            }
        }
        return true;
        
    }
}
