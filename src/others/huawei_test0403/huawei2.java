package others.huawei_test0403;

import java.util.*;

public class huawei2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> input = new HashMap<Integer, String>();
        String s = "";
        while (!(s = scanner.nextLine()).equals("")) {
            input.put(input.size() + 1, s);
        }

        List<String> validStr = new ArrayList<>();

//        System.out.println((int)'a');
        Map<Integer, String> invalidStr = new HashMap<Integer, String>();
        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i + 1);
            boolean isValid = true;
            str = str.replaceAll(" ", "");
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
//                    isValid = true;
                } else {

                    isValid = false;
                }
            }
            if (isValid) {
                validStr.add(str);
            } else {
                invalidStr.put(invalidStr.size() + 1, str);
            }

        }

        for (int i = 0; i < validStr.size(); i++) {
            System.out.print(validStr.get(i));
            if (i == validStr.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }

        for (int i = 0; i < invalidStr.size(); i++) {
            System.out.print(invalidStr.get(i + 1));
            if (i == invalidStr.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }

        for (int i = 0; i < validStr.size(); i++) {
            String myStr = validStr.get(i);
            for (int j = 0; j < 10; j++) {
                myStr = shiftLeft(myStr);
            }
            System.out.print(myStr);
            if (i == validStr.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }


    }

    public static String shiftLeft(String str) {
        if (str.length() > 1) {
            String left = str.substring(0, 1);
            String right = str.substring(1);
            return right + left;
        } else {
            return str;
        }

    }

    public static int comp(String str1, String str2) {
        if (str1.equals(str2)) {
            return 0;
        }
        int i = 0;
        int max = (str1.length() > str2.length()) ? str2.length() : str1.length();
        while (true) {
            if(i == max){
                return (str1.length() > str2.length()) ? -1:1;
            }
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 < c2) {
                return -1;
            } else if (c1 > c2) {
                return 1;
            }
            i++;
        }

    }
}
