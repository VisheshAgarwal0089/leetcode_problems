class Solution {
    public boolean judgeSquareSum(int c) {
        long left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            // int mid=left+(right-left)/2;
            if((long)(left*left+right*right)==c){
                return true;
            }
            else if((long)(left*left+right*right)<c){
                left++;
            }
            else{
                right--;
            }
        }
        return false;
    }
}