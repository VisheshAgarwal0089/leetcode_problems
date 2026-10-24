class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        long subsize=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=minK && nums[i]<=maxK){
                subsize++;
            }
            else{
                count+=subsize*(subsize+1)/2;
                subsize=0;
            }
        }
        count+=subsize*(subsize+1)/2;
        return count;
    }
}