class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        HashMap<String, Integer> map = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 0) continue;

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {

                        if (img2[x][y] == 0) continue;

                        int rowShift = x - i;
                        int colShift = y - j;

                        String key = rowShift + "," + colShift;

                        map.put(key, map.getOrDefault(key, 0) + 1);

                        ans = Math.max(ans, map.get(key));
                    }
                }
            }
        }

        return ans;
    }
}