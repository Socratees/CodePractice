package others.huawei_test0410;

import java.util.*;

public class problem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        String[] input = new String[num];
        for (int i = 0; i < num; i++) {
            input[i] = scanner.next();
        }

        //截取字符串
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String str = input[i];
            int index = 0;
            if(str.equals("") || str.length() < 1){
                continue;
            }
            while (true) {
                if (str.length() - index < 8) {
                    String substr = str.substring(index);
                    while ((!substr.equals("")) && substr.length() < 8) {
                        substr = substr + "0";
                    }
                    list.add(substr);
                    break;
                } else {
                    String substr = str.substring(index, index + 8);
                    list.add(substr);
                    index += 8;
                }
            }
        }

        Collections.sort(list);

        for(int i = 0;i <list.size(); i++){
            System.out.print(list.get(i));
            if(i != list.size() - 1){
                System.out.print(" ");
            }
        }
        System.out.println(list);
    }
}
