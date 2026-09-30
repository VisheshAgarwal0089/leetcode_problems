class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int l=seq.length();
        int arr[]=new int[l];
        int depth=1;
        // arr[0]=depth;
        int max_depth=Integer.MIN_VALUE;
        for(int i=0;i<l;i++){
            if(seq.charAt(i)=='('){
                arr[i]=depth++;
            }
            else{
                arr[i]=--depth;
            }
            max_depth=Math.max(max_depth,depth);
        }
        for(int i=0;i<l;i++){
            if(arr[i]%2==0){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }
        return arr;
    }
}