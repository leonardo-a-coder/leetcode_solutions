public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> leftList = new ArrayList<>();
        List<List<Integer>> rightList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        
        if (root == null) {
            return result;
        }
        nodeQueue.add(root);
        indexQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            int curIndex = indexQueue.poll();
            if (curIndex >= 0) {
                if (rightList.size() == curIndex) {
                    rightList.add(new ArrayList<>());
                }
                rightList.get(curIndex).add(curNode.val);
            } else {
                if (leftList.size() == -curIndex - 1) {
                    leftList.add(new ArrayList<>());
                }
                leftList.get(-curIndex - 1).add(curNode.val);
            }
            if (curNode.left != null) {
                nodeQueue.add(curNode.left);
                indexQueue.add(curIndex - 1);
            }
            if (curNode.right != null) {
                nodeQueue.add(curNode.right);
                indexQueue.add(curIndex + 1);
            }
        }
        Collections.reverse(leftList);
        result.addAll(leftList);
        result.addAll(rightList);
        return result;
    }
}
