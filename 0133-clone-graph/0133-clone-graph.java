/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cNode = new Node(node.val);
        map.put(node, cNode);
        dfs(node, cNode, map);

        return cNode;
    }

    public void dfs(Node node, Node cNode, Map<Node, Node> map) {
        for(Node n : node.neighbors) {
            if(!map.containsKey(n)) {
                Node temp = new Node(n.val);
                map.put(n, temp);
                cNode.neighbors.add(temp);
                dfs(n, temp, map);
            }else cNode.neighbors.add(map.get(n));
        }
    }

}