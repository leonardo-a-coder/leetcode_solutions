import java.util.SortedMap;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        Wall[] walls = new Wall[buildings.length << 1];
        SortedMap<Integer, Integer> heightMap = new TreeMap<>();
        int index = 0;
        int curHeight = 0;
        
        for (int i = 0; i < buildings.length; i++) {
            walls[i << 1] = new Wall(buildings[i][0], buildings[i][2]);
            walls[(i << 1) + 1] = new Wall(buildings[i][1], -buildings[i][2]);
        }
        Arrays.sort(walls);
        while (index < walls.length) {
            do {
                if (walls[index].height > 0) {
                    Integer val = heightMap.get(walls[index].height);
                    heightMap.put(walls[index].height, val == null ? 1 : val + 1);
                } else {
                    Integer val = heightMap.get(-walls[index].height);
                    if (val == 1) {
                        heightMap.remove(-walls[index].height);
                    } else {
                        heightMap.put(-walls[index].height, val - 1);
                    }
                }
                index++;
            } while (index < walls.length && walls[index].position == walls[index - 1].position);
            int maxHeight = heightMap.isEmpty() ? 0 : heightMap.lastKey();
            if (curHeight != maxHeight) {
                result.add(new int[] {walls[index - 1].position, maxHeight});
                curHeight = maxHeight;
            }
        }
        return result;
    }
    
    private class Wall implements Comparable<Wall> {
        private int position;
        private int height;
        
        public Wall(int position, int height) {
            this.position = position;
            this.height = height;
        }
        
        @Override
        public int compareTo(Wall other) {
            if (other == null) {
                return 0;
            }
            return Integer.compare(this.position, other.position);
        }
    }
}
