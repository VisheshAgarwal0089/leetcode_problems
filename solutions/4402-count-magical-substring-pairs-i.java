class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length();
        int ans = 0;
        for (int j = 0; j < n - 1; j++) {
            int[] left = new int[27];
            int[] freq = new int[26];
            int distinct = 0;

            for (int i = j; i >= 0; i--) {
                int c = s.charAt(i) - 'a';
                if (freq[c]++ == 0) {
                    distinct++;
                }
                left[distinct]++;
            }
            int[] rightFreq = new int[26];
            distinct = 0;
            for (int k = j + 1; k < n; k++) {
                int c = s.charAt(k) - 'a';

                if (rightFreq[c]++ == 0) {
                    distinct++;
                }
                ans += left[distinct];
            }
        }
        return ans;
    }
}