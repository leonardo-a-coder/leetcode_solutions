public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int index = 0;
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        int[] degrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        
        buildGraph(numCourses, prerequisites, graph, degrees);
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;
            for (int next : graph.get(cur)) {
                degrees[next]--;
                if (degrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }
    
    private void buildGraph(int numCourses, int[][] prerequisites, List<List<Integer>> graph, int[] degrees) {
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            degrees[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
    }
}
