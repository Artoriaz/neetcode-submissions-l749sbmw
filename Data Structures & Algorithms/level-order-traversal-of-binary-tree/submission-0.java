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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) {
            return new ArrayList<>();
        }
        q.add(root);
        List<List<Integer>> answer = new ArrayList<>();
        while(!q.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int currSize = q.size();
            for(int i = 0; i< currSize; i++) {
                TreeNode curr = q.poll();
                currList.add(curr.val);
                if(curr.left != null) {
                    q.add(curr.left);
                } 
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            answer.add(currList);
        }
        return answer;
    }
}
