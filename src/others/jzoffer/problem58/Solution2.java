package others.jzoffer.problem58;

public class Solution2 {
    public String reverseLeftWords(String s, int n) {
        if (n == s.length()) {
            return s;
        }
        String l = s.substring(0, n);
        String r = s.substring(n);
        return r + l;
    }
}
