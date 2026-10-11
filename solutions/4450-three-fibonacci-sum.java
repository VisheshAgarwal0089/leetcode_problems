class Solution {
    // public static long fibo(int n, long[] memo) {
    //     if (n == 0)
    //         return 0;
    //     if (n == 1)
    //         return 1;

    //     if (memo[n] != -1)
    //         return memo[n];

    //     memo[n] = fibo(n - 1, memo) + fibo(n - 2, memo);
    //     return memo[n];
    // }

    public boolean threeFibonacciSum(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        // list.add(1);
        int prev=0,cur=1;
        while(cur<=n){
           int next=prev+cur;
            list.add(cur);
            prev=cur;
            cur=next;
        }
        // Collections.reverse(list);
        if (list.size() < 4) return false;
        int l=list.size()-1;
        int sum=list.get(l-1)+list.get(l-2)+list.get(l-3);
        return sum==n;
    }
}