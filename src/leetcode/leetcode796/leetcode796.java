package leetcode.leetcode796;

public class leetcode796 {
    public boolean rotateString(String A, String B) {
        if(A.equals(B)){
            return true;
        }
        for (int i = 0; i < A.length(); i++) {
            A = rotate(A);
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }

    public static String rotate(String str) {
        if (str.equals("") || str.length() == 1) {
            return str;
        } else {
            str = str.substring(1) + str.substring(0, 1);
            return str;
        }
    }
}

