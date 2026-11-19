class Solution {
    public int minimizeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int sum1=Math.min(nums[n-1]-nums[2],nums[n-3]-nums[0]);
        sum1=Math.min(sum1,nums[n-2]-nums[1]);
        return sum1;
    }
}