class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (!st.isEmpty()) {
                    res.append(ch);
                }
                st.push(ch);
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    res.append(ch);
                }
            }
        }

        return res.toString();
        // Stack<Character> st=new Stack<>();
        // StringBuilder res=new StringBuilder();
        // int j=0;
        // for(int i=0;i<s.length();i++){
        //     if(s.charAt(i)=='('){
        //         st.push(s.charAt(i));
        //         res.append(s.charAt(i));
        //     }
        //     else{
        //         if(st.size()==1){
        //             st.pop();
        //             res.deleteCharAt(j);
        //             j=res.length();
        //             continue;
        //         }
        //         else{
        //             st.pop();
        //             res.append(s.charAt(i));
        //         }
        //     }
        // }
        // return res.toString();
    }
}