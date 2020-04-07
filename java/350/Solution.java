public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            Integer val = map.get(num);
            map.put(num, val == null ? 1 : val + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                Integer val = map.get(num);
                if (val > 1) {
                    map.put(num, val - 1);
                } else {
                    map.remove(num);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
