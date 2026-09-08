import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();

        String res = "";
        int i = 0;

        while (i < n) {
            if (i + 2 < n && s.substring(i, i + 3).equals("WUB")) {

                if (!res.isEmpty() && res.charAt(res.length() - 1) != ' ') {
                    res += " ";
                }

                i += 3;
            } else {
                res += s.charAt(i);
                i++;
            }
        }

        System.out.println(res.trim());
    }
}