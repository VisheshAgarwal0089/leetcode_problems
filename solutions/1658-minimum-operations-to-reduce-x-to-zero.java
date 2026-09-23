class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int a:nums){
            total+=a;
        }
        int target=total-x;
        if(target<0){
            return -1;
        }
        if(target==0){
            return nums.length;
        }
        int left=0;
        int maxlen=-1;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                maxlen=Math.max(maxlen,right-left+1);
            }
        }
        if(maxlen==-1){
        return -1;
        }
        return nums.length-maxlen;
    }
}