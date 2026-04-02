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
        long left;
        long right ;
        public State(TreeNode node, long left, long right) {
            this.left = left;
            this.right = right;
            this.node = node;
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
            if(!(node.val > curr.left && node.val < curr.right)) {
                return false;
            }

            if(node.left != null) {
                q.add(new State(node.left, curr.left, node.val));
            }
            if(node.right != null) {
                q.add(new State(node.right, node.val, curr.right));
            }
            
        }

        return true;
    }
}
