class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int dif[]=new int[nums1.length];
        int maxcount=0;
        for(int i=0;i<nums1.length;i++){
            dif[i]=Math.abs(nums1[i]-nums2[i]);
            maxcount=Math.max(maxcount,dif[i]);
        }
        int countdif[]=new int[maxcount+1];
        for(int num:dif){
            countdif[num]++;
        }
        long k=(long)k1+k2;
        for(int i=maxcount;i>0&&k>0;i--){
            int curcount=(int)Math.min(countdif[i],k);
            countdif[i]-=curcount;
            countdif[i-1]+=curcount;
            k-=curcount;
        }
        long res=0;
        for(int i=1;i<=maxcount;i++){
            res+=(long)countdif[i]*i*i;
        }
        return res;
    }
}