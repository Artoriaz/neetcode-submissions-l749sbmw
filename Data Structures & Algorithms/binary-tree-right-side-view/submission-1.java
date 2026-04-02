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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        if(root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int currSize = q.size();
            int val = 0;
            for(int i= 0 ; i< currSize; i++) {
                TreeNode curr = q.poll();
                val = curr.val;
                if(curr.left != null) {
                    q.add(curr.left);
                }
                 if(curr.right != null) {
                    q.add(curr.right);
                }
            }
                answer.add(val);
         

           
        }
        return answer;
    }
}
