import java.util.Arrays;

class Solution {
    public long countMagicalPairs(String s) {
        int n = s.length();
        char[] subcount = s.toCharArray();

        int[][] right = new int[n][27];
        int[] next = new int[26];
        Arrays.fill(next, n);

        // Count right substrings by distinct characters
        for (int i = n - 1; i >= 0; i--) {
            next[subcount[i] - 'a'] = i;

            int[] pos = new int[26];
            int size = 0;

            for (int p : next) {
                if (p < n) {
                    pos[size++] = p;
                }
            }

            Arrays.sort(pos, 0, size);

            for (int d = 1; d < size; d++) {
                right[i][d] = pos[d] - pos[d - 1];
            }

            right[i][size] = n - pos[size - 1];
        }

        long ans = 0;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Count left substrings by distinct characters
        for (int j = 0; j < n - 1; j++) {
            last[subcount[j] - 'a'] = j;

            int[] pos = new int[26];
            int size = 0;

            for (int p : last) {
                if (p >= 0) {
                    pos[size++] = p;
                }
            }

            Arrays.sort(pos, 0, size);

            for (int d = 1; d <= size; d++) {
                int idx = size - d;

                int count = pos[idx]
                        - (idx == 0 ? -1 : pos[idx - 1]);

                ans += (long) count * right[j + 1][d];
            }
        }

        return ans;
    }
}