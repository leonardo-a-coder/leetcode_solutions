public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (((len1 + len2) & 1) == 0) {
            return ((double) findKthNumber(nums1, nums2, (len1 + len2) >>> 1) 
                + findKthNumber(nums1, nums2, ((len1 + len2) >>> 1) + 1)) / 2;
        } else {
            return findKthNumber(nums1, nums2, ((len1 + len2) >>> 1) + 1);
        }
    }
    
    private int findKthNumber(int[] nums1, int[] nums2, int k) {
        return findKthNumber(nums1, nums2, 0, nums1.length, 0, nums2.length, k);
    }
    
    private int findKthNumber(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        if (end1 - start1 > end2 - start2) {
            return findKthNumber(nums2, nums1, start2, end2, start1, end1, k);
        }
        if (start1 == end1) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = Math.min(k / 2, end1 - start1);
        int mid2 = k - mid1;
        if (nums1[start1 + mid1 - 1] < nums2[start2 + mid2 - 1]) {
            return findKthNumber(nums1, nums2, start1 + mid1, end1, start2, end2, k - mid1);
        } else if (nums1[start1 + mid1 - 1] > nums2[start2 + mid2 - 1]) {
            return findKthNumber(nums1, nums2, start1, end1, start2 + mid2, end2, k - mid2);
        } else {
            return nums1[start1 + mid1 - 1];
        }
    }
}
