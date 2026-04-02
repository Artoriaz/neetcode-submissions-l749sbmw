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
class State {
    TreeNode node;
    int depth;
     State(TreeNode node, int depth) {
        this.node = node;
        this.depth= depth;
     }
}
class Solution {
   
    public int maxDepth(TreeNode root) {
        Queue<State> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new State(root, 1));
        }
        int ans =0;
        while(!queue.isEmpty()) {
            State poppedState = queue.poll();
            TreeNode popped = poppedState.node;
            int depth = poppedState.depth;

            ans = Math.max(ans, depth);

            if(popped.right != null) {
                queue.add(new State(popped.right, depth + 1));
            }

            if(popped.left != null) {
                queue.add(new State(popped.left, depth + 1));
            }
        }

        return ans;
    }
}
