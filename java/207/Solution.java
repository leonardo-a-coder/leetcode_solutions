public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degrees = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = numCourses;
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            degrees[prerequisite[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                count--;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                degrees[next]--;
                if (degrees[next] == 0) {
                    queue.add(next);
                    count--;
                }
            }
        }
        return count == 0;
    }
}
