class Solution {
    public int reverseDegree(String s) {
        int i=1;
        int sum=0;
        char s1[]=s.toCharArray();
        for(char ch:s1){
            sum+=i++ *(26-(ch-'a'));
        }
        return sum;
    }
}