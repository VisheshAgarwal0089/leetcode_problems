class Solution {
    public int scoreOfParentheses(String s) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(') {
                stack.push(count);
                count = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    count = stack.peek() + 1;
                } else {
                    // stack.push(count);☻
                    count = stack.peek() + 2 * count;
                }
                stack.pop();
            }
        return count;
    }
}