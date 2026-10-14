class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        while (num > 0) {
            int digit = Math.min(9, sum);

            res.append(digit);
            sum -= digit;
            num--;
        }

        return res.toString();
    }
}