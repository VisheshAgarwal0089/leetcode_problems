class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long sum=0;
        int hf=nums.length/2;
        for(int i=0;i<hf;i++){
            sum=sum+nums[i+hf]-nums[i];
        }
        if(nums.length%2!=0){
            sum+=nums[hf*2];
        }
        return sum;
    }
}