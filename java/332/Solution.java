public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        String[] path = new String[tickets.length + 1];
        path[0] = "JFK";
        Map<String, List<String>> graph = buildGraph(tickets);
        if (dfs(path, 1, graph)) {
            return Arrays.asList(path);
        }
        return new ArrayList<>();
    }
    
    private Map<String, List<String>> buildGraph(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                graph.put(ticket[0], new ArrayList<>());
            }
            graph.get(ticket[0]).add(ticket[1]);
        }
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
        }
        return graph;
    }
    
    private boolean dfs(String[] path, int index, Map<String, List<String>> graph) {
        if (index == path.length) {
            return true;
        }
        List<String> nextCities = graph.get(path[index - 1]);
        if (nextCities == null) {
            return false;
        }
        for (int i = 0; i < nextCities.size(); i++) {
            String nextCity = nextCities.get(i);
            if (nextCity == null) {
                continue;
            }
            path[index] = nextCity;
            nextCities.set(i, null);
            if (dfs(path, index + 1, graph)) {
                return true;
            }
            nextCities.set(i, nextCity);
        }
        return false;
    }
}
