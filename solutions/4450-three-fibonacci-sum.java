class Solution {
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