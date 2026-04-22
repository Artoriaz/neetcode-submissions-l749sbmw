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
    //bfs
    HashMap<Node,Node> cloned = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        cloned.put(node, new Node(node.val));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(Node nei: cur.neighbors) {
                if(!cloned.containsKey(nei)) {
                    cloned.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                cloned.get(cur).neighbors.add(cloned.get(nei));
            }
        }

        return cloned.get(node);
    }
}