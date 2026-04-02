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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root, str);

        return str.toString();
    }

    public void dfs(TreeNode node , StringBuilder str) {
        if(node == null) { str.append("N,");return; }
        str.append(node.val + ",");
        dfs(node.left, str);
        dfs(node.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return remakeTree(q);

    }

    public TreeNode remakeTree(Queue<String> q) {
        String val = q.poll();
        if(val.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = remakeTree(q);
        node.right = remakeTree(q);
        return node;
    }
}
