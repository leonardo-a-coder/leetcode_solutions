public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        dfs(node, result, map);
        return result;
    }
    
    private void dfs(UndirectedGraphNode oldNode, UndirectedGraphNode newNode, Map<Integer, UndirectedGraphNode> map) {
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
            UndirectedGraphNode newNeighbor = map.get(oldNeighbor.label);
            if (newNeighbor == null) {
                newNeighbor = new UndirectedGraphNode(oldNeighbor.label);
                dfs(oldNeighbor, newNeighbor, map);
            }
            newNode.neighbors.add(newNeighbor);
        }
    }
}


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<>();
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        nodeMap.put(result.label, result);
        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()) {
            UndirectedGraphNode oldNode = nodeQueue.poll();
            UndirectedGraphNode newNode = nodeMap.get(oldNode.label);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                if (!nodeMap.containsKey(oldNeighbor.label)) {
                    nodeMap.put(oldNeighbor.label, new UndirectedGraphNode(oldNeighbor.label));
                    nodeQueue.add(oldNeighbor);
                }
                newNode.neighbors.add(nodeMap.get(oldNeighbor.label));
            }
        }
        return result;
    }
}
