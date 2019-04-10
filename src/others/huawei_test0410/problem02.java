package others.huawei_test0410;

import java.util.Scanner;

public class problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String result = "";

//        System.out.println((int)'1');
        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            if (isNumber(input.substring(i, i + 1))) {
                num = Integer.parseInt(input.substring(i, i + 1));
            } else if (input.substring(i, i + 1).equals("(")) {
                int start = i + 1;
                while (!input.substring(i, i + 1).equals(")")) {
                    i++;
                }
                for (int j = 0; j < num; j++) {
                    result += input.substring(start, i);
                }

            } else {
                result += input.substring(i, i + 1);
            }
        }

        String output = "";
        for(int i = result.length() - 1;i >=0; i--){
            output += result.substring(i,i+1);
        }
        System.out.println(output);
    }

    public static boolean isNumber(String s) {
        char c = s.charAt(0);
        if (c >= 48 && c <= 57) {
            return true;
        }
        return false;
    }


}
