public class NumArray {
    private int[] tree;
    private int length;

    public NumArray(int[] nums) {
        length = nums.length;
        if (length == 0) {
            tree = new int[0];
            return;
        }
        tree = new int[(int) Math.pow(2, Math.ceil(Math.log(length) / Math.log(2)) + 1) - 1];
        buildTree(nums, 0, length - 1, 0);
    }

    void update(int i, int val) {
        update(i, val, 0, length - 1, 0);
    }

    public int sumRange(int i, int j) {
        return sumRange(i, j, 0, length - 1, 0);
    }
    
    private int buildTree(int[] nums, int start, int end, int node) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = start + ((end - start) >> 1);
            int left = buildTree(nums, start, mid, (node << 1) + 1);
            int right = buildTree(nums, mid + 1, end, (node << 1) + 2);
            tree[node] = left + right;
        }
        return tree[node];
    }
    
    private void update(int i, int val, int start, int end, int node) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = start + ((end - start) >> 1);
            if (start <= i && i <= mid) {
                update(i, val, start, mid, (node << 1) + 1);
            } else {
                update(i, val, mid + 1, end, (node << 1) + 2);
            }
            tree[node] = tree[(node << 1) + 1] + tree[(node << 1) + 2];
        }
    }
    
    private int sumRange(int i, int j, int start, int end, int node) {
        if (i <= start && end <= j) {
            return tree[node];
        } else if (i > end || j < start) {
            return 0;
        } else {
            int mid = start + ((end - start) >> 1);
            return sumRange(i, j, start, mid, (node << 1) + 1) + sumRange(i, j, mid + 1, end, (node << 1) + 2);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
