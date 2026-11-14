// class Solution {
//     public int minimumSumSubarray(List<Integer> nums, int l, int r) {
//         int n = nums.size();
//         int[] prefix = new int[n];
//         prefix[0] = nums.get(0);
//         for (int i = 1; i < n; i++) {
//             prefix[i] = prefix[i - 1] + nums.get(i);
//         }
//         int left=0,righht=0;
//         int sum=0;
//         int min=Math.MAX_VALUE;
//         while(right<=nums.size()){
//             sum=sum+
//             while()
//         }
//     }
// }
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] prefix = new int[n];
        prefix[0] = nums.get(0);

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums.get(i);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + l - 1; j < n && j < i + r; j++) {

                int sum;

                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }

                if (sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}