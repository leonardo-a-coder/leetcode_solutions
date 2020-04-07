public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        pathSum(root, sum, result, new ArrayList<>());
        return result;
    }
    
    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            pathSum(root.left, sum, result, list);
        }
        if (root.right != null) {
            pathSum(root.right, sum, result, list);
        }
        list.remove(list.size() - 1);
    }
}
