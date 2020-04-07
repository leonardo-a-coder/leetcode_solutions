public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2) {
            return false;
        }
        long longT = t;
        NumWithIndex[] nwi = new NumWithIndex[nums.length];
        generateNumWithIndex(nums, nwi);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length && nwi[j].num - nwi[i].num <= t; j++) {
                if (Math.abs(nwi[i].index - nwi[j].index) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private void generateNumWithIndex(int[] nums, NumWithIndex[] nwi) {
        for (int i = 0; i < nums.length; i++) {
            nwi[i] = new NumWithIndex(nums[i], i);
        }
        Arrays.sort(nwi, new Comparator<NumWithIndex>() {
            @Override
            public int compare(NumWithIndex nwi1, NumWithIndex nwi2) {
                return Long.compare(nwi1.num, nwi2.num);
            }
        });
    }
    
    private class NumWithIndex {
        private long num;
        private int index;
        
        public NumWithIndex(long num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
