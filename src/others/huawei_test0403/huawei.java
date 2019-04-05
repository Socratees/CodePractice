package others.huawei_test0403;


import java.util.*;

public class huawei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        //        //结果
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //输入
        Map<Integer, String> input = new HashMap<Integer, String>();
        String s = "";
        while (!(s = scanner.nextLine()).equals("")) {
            input.put(input.size() + 1, s);
        }

//        while (scanner.hasNextLine()){
//            s = scanner.nextLine();
//            input.put(input.size() + 1, s);
//        }

        int[] indexs = new int[input.size()];
        for (int i = 0; i < indexs.length; i++) {
            indexs[i] = 0;
        }

        while (true) {
            boolean flag = false;
            for (int k = 0; k < input.size(); k++) {
                String[] numbers = input.get(k + 1).split(",");
                if (indexs[k] < numbers.length) {
                    for (int i = 0; i < num; i++) {
                        if (indexs[k] < numbers.length) {
                            map.put(map.size() + 1, Integer.parseInt(numbers[indexs[k]]));
                            indexs[k]++;
                            flag = true;
                        }
                    }
                }
            }

            if (!flag){
                break;
            }

        }

        for (int i = 0; i < map.size(); i++) {
            System.out.print(map.get(i + 1));
            if (i != map.size() - 1) {
                System.out.print(",");
            }
        }


    }
}
