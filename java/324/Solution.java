public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int median = findKthNumber(nums, (nums.length + 1) / 2, min, max);
        int bigIndex = 1;
        int smallIndex = (nums.length & 1) == 0 ? nums.length - 2 : nums.length - 1;
        int curIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[curIndex] > median) {
                swap(nums, curIndex, bigIndex);
                curIndex += 2;
                bigIndex += 2;
                if (curIndex >= nums.length) {
                    curIndex = 0;
                }
                if (bigIndex >= nums.length) {
                    bigIndex = 0;
                }
            } else if (nums[curIndex] < median) {
                swap(nums, curIndex, smallIndex);
                smallIndex -= 2;
                if (smallIndex < 0) {
                    smallIndex = (nums.length & 1) == 0 ? nums.length - 1 : nums.length - 2;
                }
            } else {
                curIndex += 2;
                if (curIndex >= nums.length) {
                    curIndex = 0;
                }
            }
        }
    }
    
    private int findKthNumber(int[] nums, int k, int min, int max) {
        while (min <= max) {
            int mid = 0;
            if (min < 0 && max > 0) {
                mid = (min + max) / 2;
            } else {
                mid = min + (max - min) / 2;
            }
            int smallerCount = 0;
            int biggerCount = 0;
            boolean found = true;
            for (int num : nums) {
                if (num < mid) {
                    smallerCount++;
                    if (smallerCount > k) {
                        max = mid - 1;
                        found = false;
                        break;
                    }
                } else if (num > mid) {
                    biggerCount++;
                    if (biggerCount > nums.length - k) {
                        min = mid + 1;
                        found = false;
                        break;
                    }
                }
            }
            if (found) {
                return mid;
            }
        }
        return min;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
