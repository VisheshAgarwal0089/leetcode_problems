class Solution {
    public int minOperations(String s) {
         int n = s.length();

        // Check if already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }

        if (sorted) return 0;

        // An unsorted string of length 2 cannot be sorted
        if (n == 2) return -1;

        char mn = 'z';
        char mx = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            mn = (char) Math.min(mn, c);
            mx = (char) Math.max(mx, c);
        }

        // One operation is enough
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }

        // Check the proper middle substring
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx) {
                return 2;
            }
        }

        // Otherwise, three operations are needed
        return 3;
    }
}