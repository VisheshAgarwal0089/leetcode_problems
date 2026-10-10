class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int x = k;
        int ans = 1, i = 0;

        while (i < n) {
            int r = nums[i] % x;
            int j = i;

            while (j < n && nums[j] % x == r) {
                j++;
            }

            int len = j - i;

            if (r == 0) {
                ans = Math.max(ans, len);
            } else {
                int g = gcd(r, x);
                int step = x / g;
                int valid = 1 + ((len - 1) / step) * step;

                ans = Math.max(ans, valid);
            }

            i = j;
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}