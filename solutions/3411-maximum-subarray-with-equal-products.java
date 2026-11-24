class Solution {
    public int maxLength(int[] nums) {
        int max=2;
        int left=0;
        for(int right=0;right<nums.length;right++){
            while(!isValid(nums,left,right)){
                left++;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
    boolean isValid(int nums[],int left,int right){
        for(int i=left;i<=right;i++){
            for(int j=i+1;j<=right;j++){
                if(gcd(nums[i],nums[j])!=1){
                    return false;
                }
            }
        }
        return true;
    }
    int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}