package leetcode.leetcode557;

public class leetcode557 {
    public String reverseWords(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals(" ")) {
                for (int j = i-1; j >= 0; j--) {
                    if (j != i && s.substring(j, j + 1).equals(" ")) {
                        break;
                    } else {
                        str = str + s.substring(j, j + 1);
                    }
                }
                str = str+" ";
            }else if(i == s.length() - 1){
                for (int j = i; j >= 0; j--) {
                    if (j != i && s.substring(j, j + 1).equals(" ")) {
                        break;
                    } else {
                        str = str + s.substring(j, j + 1);
                    }
                }
            }


        }

        return str;
    }
}
