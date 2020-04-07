public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int[] cur1 = maxKNumber(nums1, i);
            int[] cur2 = maxKNumber(nums2, k - i);
            int[] cur = merge(cur1, cur2);
            if (compare(result, cur, 0, 0) < 0) {
                result = cur;
            }
        }
        return result;
    }
    
    private int[] maxKNumber(int[] nums, int k) {
        int[] result = new int[k];
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            while (end >= 0 && nums.length - i >= k - end && nums[i] > result[end]) {
                end--;
            }
            if (end < k - 1) {
                result[++end] = nums[i];
            }
        }
        return result;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (compare(nums1, nums2, index1, index2) > 0) {
                result[index++] = nums1[index1++];
            } else {
                result[index++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) {
            result[index++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            result[index++] = nums2[index2++];
        }
        return result;
    }
    
    private int compare(int[] nums1, int[] nums2, int index1, int index2) {
        while (index1 < nums1.length && index2 < nums2.length) {
            int cur = Integer.compare(nums1[index1++], nums2[index2++]);
            if (cur != 0) {
                return cur;
            }
        }
        return index1 == nums1.length ? -1 : 1;
    }
}
