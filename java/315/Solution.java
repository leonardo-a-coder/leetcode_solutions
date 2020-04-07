public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Tree tree = new Tree();
        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(tree.insert(nums[i]));
        }
        Collections.reverse(result);
        return result;
    }
    
    private class Tree {
        private TreeNode root;
        
        private int insert(int val) {
            if (root == null) {
                root = new TreeNode(val);
                return 0;
            }
            int count = 0;
            TreeNode cur = root;
            while (true) {
                if (cur.val > val) {
                    cur.leftCount++;
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur.left = new TreeNode(val);
                        break;
                    }
                } else if (cur.val < val) {
                    count += cur.leftCount + cur.selfCount;
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur.right = new TreeNode(val);
                        break;
                    }
                } else {
                    cur.selfCount++;
                    count += cur.leftCount;
                    break;
                }
            }
            return count;
        }
    }
    
    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;
        private int leftCount;
        private int selfCount;
        
        TreeNode(int val) {
            this.val = val;
            this.selfCount = 1;
        }
    }
}

