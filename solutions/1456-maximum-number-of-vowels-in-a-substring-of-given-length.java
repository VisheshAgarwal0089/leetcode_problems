class Solution {
    public int maxVowels(String s, int k) {
        int max=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a' ||
            s.charAt(i)=='e' ||
            s.charAt(i)=='i' ||
            s.charAt(i)=='o' ||
            s.charAt(i)=='u' 
            ){
                count++;
            }
        }
        max=Math.max(max,count);
        int j=k;
        int a=0;
        while(j<s.length()){
            if(s.charAt(j)=='a' ||
            s.charAt(j)=='e' ||
            s.charAt(j)=='i' ||
            s.charAt(j)=='o' ||
            s.charAt(j)=='u' 
            ){
                count++;
            }
            if(s.charAt(a)=='a' ||
            s.charAt(a)=='e' ||
            s.charAt(a)=='i' ||
            s.charAt(a)=='o' ||
            s.charAt(a)=='u' 
            ){
                count--;
            }
            max=Math.max(max,count);
            a++;
            j++;
        }
        return max;
    }
}