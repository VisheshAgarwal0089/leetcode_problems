class Solution {
    static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        Integer arr[] = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int sumA = sumOfDigits(a);
            int sumB = sumOfDigits(b);

            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); //mpa the actual array wiht idx
        }
        int swaps = 0;
        for (int i = 0; i < nums.length; i++) {
            int reqval = arr[i];
            int curval = nums[i];
            if (reqval == curval)
                continue;
            int idx=map.get(reqval);
            nums[i] = reqval;
            nums[idx] = curval;
            map.put(nums[i],i);
            map.put(nums[idx],idx);
            swaps++;
        }
        return swaps;
    }
}