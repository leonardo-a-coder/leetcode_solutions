public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n, n + 1, new HashMap<>());
    }
    
    private List<TreeNode> generateTrees(int start, int end, int base, Map<Long, List<TreeNode>> cache) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        long key = hash(base, start, end);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1, base, cache);
            List<TreeNode> rights = generateTrees(i + 1, end, base, cache);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        cache.put(key, result);
        return result;
    }
    
    private long hash(int base, int... nums) {
        long result = 0;
        for (int num : nums) {
            result = result * base + num;
        }
        return result;
    }
}
