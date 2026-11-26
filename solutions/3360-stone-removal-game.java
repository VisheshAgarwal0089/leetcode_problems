class Solution {
    public boolean canAliceWin(int n) {
        int x = 10;
        boolean alice=true;
        while (n>= x) {
            n = n - x;
            x = x - 1;
            alice=!alice;
        }
        return !alice;
    }
}