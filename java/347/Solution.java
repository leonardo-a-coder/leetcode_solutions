public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.get(num);
            map.put(num, val == null ? 1 : val + 1);
        }
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            list.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        int index = max;
        while (k > 0) {
            while (index >= 0 && list.get(index).isEmpty()) {
                index--;
            }
            if (index < 0) {
                break;
            }
            Iterator<Integer> iter = list.get(index--).iterator();
            while (k > 0 && iter.hasNext()) {
                result.add(iter.next());
                k--;
            }
        }
        return result;
    }
}
