/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> cloned = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
   public Node dfs(Node node) {
    if(node == null) return null; 
    if(cloned.containsKey(node)) return cloned.get(node); // already cloned, return it
    
    Node clone = new Node(node.val); // create the clone
    cloned.put(node, clone);         // register it
    
    for(Node neigh: node.neighbors) {
        clone.neighbors.add(dfs(neigh)); // clone each neighbor and add to clone's list
    }
    return clone;
}
}