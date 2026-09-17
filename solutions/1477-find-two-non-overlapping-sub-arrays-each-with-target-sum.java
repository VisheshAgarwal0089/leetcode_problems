class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        int cursum = 0;
        int mintillidx[] = new int[n];
        Arrays.fill(mintillidx, Integer.MAX_VALUE);
        int bestmin = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while (j < n) {
            cursum += arr[j];
            while (i < j && cursum > target) {
                cursum -= arr[i++];
            }
            if (cursum == target) {
                int len = j - i + 1;
                if (i > 0 && mintillidx[i - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, len + mintillidx[i - 1]);
                }
                bestmin = Integer.min(len, bestmin);
            }
            mintillidx[j]=bestmin;
            j++;
        }
        return res==Integer.MAX_VALUE ?-1 :res;
    }
}