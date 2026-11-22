class Solution {
    public boolean checkString(String s) {
        int bcount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b')bcount++;
            if(s.charAt(i)=='a'&&bcount>0)return false;
        }
        return true;
    }
}