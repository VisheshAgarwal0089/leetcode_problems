class Solution {
    public int peakValleyDifference(int[] nums) {
        int valleys=0;
        int peak=0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1])peak+=nums[i];
            if(nums[i]<nums[i-1]&&nums[i]<nums[i+1])valleys+=nums[i];
        }
        return peak-valleys;
    }
}