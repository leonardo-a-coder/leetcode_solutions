public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
    private String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
