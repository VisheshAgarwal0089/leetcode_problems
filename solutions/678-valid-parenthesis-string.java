class Solution {
    public boolean checkValidString(String s) {
        int l=s.length();
        Stack<Integer> open=new Stack<>();
        Stack<Integer> star=new Stack<>();
        // stack.push(-1);
        for(int i=0;i<l;i++){
            if(s.charAt(i)=='('){
                open.push(i);
            }
            else if(s.charAt(i)=='*'){
                star.push(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!open.isEmpty()&&!star.isEmpty()){
            if(open.peek()<star.peek()){
                open.pop();
                star.pop();
            }
            else{
                return false;
            }
        }
        return open.isEmpty();
    }
}