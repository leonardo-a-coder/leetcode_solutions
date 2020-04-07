import java.util.LinkedHashMap;

public class TwoSum {
    Map<Long, Boolean> numDuplicateMap;
    
    public TwoSum() {
        numDuplicateMap = new LinkedHashMap<>();
    }

    // Add the number to an internal data structure.
	public void add(int number) {
	    long num = (long) number;
	    numDuplicateMap.put(num, numDuplicateMap.containsKey(num) ? true : false);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Long, Boolean> entry : numDuplicateMap.entrySet()) {
	        long key = entry.getKey();
	        boolean val = entry.getValue();
	        if (numDuplicateMap.containsKey((long) value - key) && (value >> 1 != key || val)) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
