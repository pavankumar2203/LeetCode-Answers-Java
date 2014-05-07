/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        //clone node and append it to neighbors
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        dfs1(node, set);
        //add neighbors to cloned node
        set.clear();
        dfs2(node, set);
        
        UndirectedGraphNode newNode = node.neighbors.get(node.neighbors.size()-1);
        
        //remove cloned node from neighbors list
        set.clear();
        dfs3(node, set);
        
        return newNode;
    }
    private void dfs1(UndirectedGraphNode node, HashSet<UndirectedGraphNode> set) {
        set.add(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        node.neighbors.add(newNode);
        for(UndirectedGraphNode n : node.neighbors) {
            if(n!=newNode && !set.contains(n)) {
                dfs1(n, set);
            }
        }
    }
    private void dfs2(UndirectedGraphNode node, HashSet<UndirectedGraphNode> set) {
        set.add(node);
        UndirectedGraphNode newNode = node.neighbors.get(node.neighbors.size()-1);
        for(int i = 0; i < node.neighbors.size() -1; i++) {
            UndirectedGraphNode n = node.neighbors.get(i);
            newNode.neighbors.add(n.neighbors.get(n.neighbors.size()-1));
            if(!set.contains(n)) {
                dfs2(n, set);
            }
        }
    }
    private void dfs3(UndirectedGraphNode node, HashSet<UndirectedGraphNode> set) {
        set.add(node);
        node.neighbors.remove(node.neighbors.size()-1);
        for(UndirectedGraphNode n : node.neighbors) {
            if(!set.contains(n)) {
                dfs3(n,set);
            }
        }
    }
}
