class Solution {
    int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    int min(int a,int b, int c){
        return Math.min(a,Math.min(b,c));
    }
    public int minRange(int a, int b, int c) {
        if(a+b<c){
            c=a+b;
        }
        if(b+c<a){
            a=b+c;
        }
        if(a+c<b){
            b=a+c;
        }
        return max(a,b,c)-min(a,b,c);
    }
}