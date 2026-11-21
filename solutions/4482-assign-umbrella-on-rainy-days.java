class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;
        String res[] = new String[n];
        int alicecount = 0;
        int bobcount = 0;
        res[n-1]="None";
        for (int i = 0; i < n-1; i++) {
            if (rain[i] == 1) {
                if (rain[i + 1] == 1) {
                    if (alicecount <= bobcount) {
                        res[i] = "Alice";
                        alicecount++;
                    } else {
                        res[i] = "Bob";
                        bobcount++;
                    }
                } else {
                    res[i]="Bob";
                    bobcount++;
                }
            }
            else{
                res[i]="None";
            }
        }
        if(rain[n-1]==1){
            res[n-1]="Bob";
        }
        return res;
    }
}