class Solution {
    private int MIN;
public List<String> removeInvalidParentheses(String s) {
    MIN = getMinParenRemoved(s);
    List<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    dfs(s, 0, 0, "", set, 0);
    list.addAll(set);
    return list;
}

private void dfs(String s, int index, int currOpen, String formed, Set<String> list, int removed) {
    int N = s.length();
    if (index == N && currOpen == 0) {
        list.add(formed);
        return;
    }
    if (removed > MIN  || index == N) {
        return;
    }
    if (s.charAt(index) == '(') {
        dfs(s, index+1, currOpen+1, formed + s.charAt(index), list, removed);
        dfs(s, index+1, currOpen, formed, list, removed+1);
    } else if (s.charAt(index) == ')') {
        if (currOpen > 0) {
            dfs(s, index+1, currOpen-1, formed + s.charAt(index), list, removed);
        }

        dfs(s, index+1, currOpen, formed, list, removed+1);
    } else {
        dfs(s, index+1, currOpen, formed + s.charAt(index), list, removed);
    }
}

private int getMinParenRemoved(String str) {
    int open = 0;
    int ans = 0;
    for (int i=0;i<str.length();i++) {
        char ch = str.charAt(i);
        if (ch == '(') {
            open++;
        } else if (ch == ')') {
            if (open > 0) {
                open--;
            } else {
                ans++;
            }
        }
    }
    return (ans + open);
}
}