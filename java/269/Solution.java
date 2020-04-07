public class Solution {
    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        int[] degrees = new int[26];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        buildGraph(words, graph, degrees);
        for (int i = 0; i < 26; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                degrees[i]--;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append((char) (cur + 'a'));
            for (int next : graph.get(cur)) {
                degrees[next]--;
                if (degrees[next] == 0) {
                    queue.add(next);
                    degrees[next]--;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (degrees[i] > 0) {
                return "";
            } else if (degrees[i] == 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
    
    private void buildGraph(String[] words, List<List<Integer>> graph, int[] degrees) {
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(degrees, -1);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                degrees[word.charAt(i) - 'a'] = 0;
            }
        }
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < Math.min(words[i - 1].length(), words[i].length()); j++) {
                int index1 = words[i - 1].charAt(j) - 'a';
                int index2 = words[i].charAt(j) - 'a';
                if (index1 != index2) {
                    graph.get(index1).add(index2);
                    degrees[index2]++;
                    break;
                }
            }
        }
    }
}
