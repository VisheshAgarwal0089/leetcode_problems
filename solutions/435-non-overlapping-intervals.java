class Solution {
    public int eraseOverlapIntervals(int[][] interval) {
        // ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        // ArrayList<Integer> lst=new ArrayList<>();
        Arrays.sort(interval, (a, b) -> Integer.compare(a[0], b[0]));
        int end = interval[0][1];
        int count = 0;
        for (int i = 1; i < interval.length; i++) {
            if (end> interval[i][0]) {
                    count++;
                    end=Math.min(end,interval[i][1]);
            } else {
                end = interval[i][1];
            }
        }
        return count;
    }
}