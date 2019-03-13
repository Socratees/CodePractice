package leetcode.leetcode709;

public class leetcode709 {
    public String toLowerCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            c = (char) ((c >= 65 && c < 90) ? (c + 32) : c);
            String head = "";
            String tail = "";
            head = str.substring(0, i);
            tail = str.substring(i + 1, str.length());

            str = head + String.valueOf(c) + tail;
        }
        return str;
    }
}
