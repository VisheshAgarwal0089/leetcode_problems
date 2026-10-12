class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int count[] = new int[32];
        int mod = 1_000_000_007;

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        long res = 0;
        while (k-- > 0) {
            long cur = 0;
            for (int i = 0; i < 32; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    cur = (cur | 1 << i);
                }
            }
            res = (res + cur * cur % mod) % mod;
        }
        return (int) res;
    }
}