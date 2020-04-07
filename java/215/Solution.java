import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        k = nums.length - k;
        shuffle(nums);
        while (start <= end) {
            int i = start;
            int j = end;
            while (i < j) {
                while (i < j && nums[i] < nums[end]) {
                    i++;
                }
                while (i < j && nums[j] >= nums[end]) {
                    j--;
                }
                if (i == j) {
                    break;
                }
                swap(nums, i, j);
            }
            swap(nums, i, end);
            if (i < k) {
                start = i + 1;
            } else if (i > k) {
                end = i - 1;
            } else {
                return nums[i];
            }
        }
        return 0;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }
    }
}
