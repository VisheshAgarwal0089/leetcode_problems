class Solution {
    private Set<String> set=new HashSet<>();
    private int n;
    private int maxlen;
    private void solve(String s,int i,StringBuilder cur,int count){
        if(count<0)return;
        if(i==n){
            if(count==0){
                if(maxlen<cur.length()){
                    maxlen=cur.length();
                    set.clear();
                }
                if(cur.length()==maxlen){
                    set.add(cur.toString());
                }
            }
            return;
        }
        char c=s.charAt(i);
        if(s.charAt(i)!='(' && s.charAt(i)!=')'){
            cur.append(c);
            solve(s, i + 1, cur, count);
            cur.deleteCharAt(cur.length() - 1);
            return;
        }
        cur.append(c);
        solve(s,i+1,cur,count+(c=='('?1:-1));
        cur.deleteCharAt(cur.length()-1);
        solve(s,i+1,cur,count);

    }
    public List<String> removeInvalidParentheses(String s) {
        n=s.length();
        maxlen=0;
        set.clear();
        solve(s,0,new StringBuilder(),0);
        return new ArrayList<>(set);
    }
}