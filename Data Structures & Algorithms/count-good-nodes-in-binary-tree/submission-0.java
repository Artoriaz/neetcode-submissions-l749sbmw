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
    int counter = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return counter;
    }
    public void dfs(TreeNode node, Integer maxValue) {
        if (node == null) {
            return;
        }
        
        if(node.val  >= maxValue) {
            counter++;
        }
        maxValue = Math.max(maxValue, node.val);
        dfs(node.left, maxValue);
        dfs(node.right, maxValue);
    }
}
