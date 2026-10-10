class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int maxprod = Integer.MIN_VALUE;
        int a = -1, b = -1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target &&
                    nums[i] > nums[j]) {

                    int prod = nums[i] * nums[j];

                    if (prod > maxprod) {
                        maxprod = prod;
                        a = i;
                        b = j;
                    }
                } else if (nums[i] + nums[j] == target &&
                           nums[j] > nums[i]) {

                    int prod = nums[i] * nums[j];

                    if (prod > maxprod) {
                        maxprod = prod;
                        a = j;
                        b = i;
                    }
                }
            }
        }

        return new int[]{a, b};
    }
}