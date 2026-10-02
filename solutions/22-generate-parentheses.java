class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        backtrack("",0,0,n,list);
        return list;
    }
    void backtrack(String s,int open,int close,int n,List<String> ans){
        if(s.length()==n*2){
            ans.add(s);
            return;
        }
        if(open<n){
            backtrack(s+"(",open+1,close,n,ans);
        }
        if(close<open){
            backtrack(s+")",open,close+1,n,ans);
        }
    }
}