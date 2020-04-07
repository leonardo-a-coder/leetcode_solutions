public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] degrees = new int[n];
        int count = n;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] <= 1) {
                queue.add(i);
                count--;
            }
        }
        while (count > 0) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                for (int neighbor : graph.get(cur)) {
                    degrees[neighbor]--;
                    if (degrees[neighbor] == 1) {
                        queue.add(neighbor);
                        count--;
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
