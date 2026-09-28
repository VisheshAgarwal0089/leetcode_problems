class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=s.length();
        int arr[]=new int[127];
        Arrays.fill(arr,0);
        int max=0;
        for(int i=0,j=0;i<l;i++){
                arr[s.charAt(i)]++;
            while(arr[s.charAt(i)]>1 && i>j){
                arr[s.charAt(j)]--;
                j++;
            }
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}