package others.help0313;

import java.util.Scanner;

/**
 * @Description:
 * @Author: liuzhibiao
 * @Date: 2019/3/13
 */
public class test {
    public static void main(String[] args) {
        System.out.println("请输入最大生命值：");
        Scanner scan1 = new Scanner(System.in);
        String fullBlood = scan1.nextLine();

        System.out.println("请输入当前生命值：");
        Scanner scan2 = new Scanner(System.in);
        String currentBlood = scan2.nextLine();

        double maxBlood = Double.parseDouble(fullBlood);
        double myBlood = Double.parseDouble(currentBlood);

        if (myBlood <= maxBlood && maxBlood > 0 && myBlood >= 0) {
            double ratio = (maxBlood - myBlood) / maxBlood;
            double increase = 0;
            if (myBlood > maxBlood * 0.9) {
                increase = 0;
            } else if (myBlood > maxBlood * 0.8) {
                increase = 0.06;
            } else if (myBlood > maxBlood * 0.7) {
                increase = 0.06 * 2;
            } else if (myBlood > maxBlood * 0.6) {
                increase = 0.06 * 3;
            } else if (myBlood > maxBlood * 0.5) {
                increase = 0.06 * 4;
            } else if (myBlood > maxBlood * 0.4) {
                increase = 0.06 * 5;
            } else if (myBlood > maxBlood * 0.3) {
                increase = 0.06 * 6;
            } else if (myBlood > maxBlood * 0.2) {
                increase = 0.06 * 7;
            } else if (myBlood > maxBlood * 0.1) {
                increase = 0.06 * 8;
            } else if (myBlood > 0) {
                increase = 0.06 * 9;
            } else {
                increase = 0.06 * 10;
            }

            System.out.println("损失生命值" + String.valueOf(ratio * 100) + "%");
            System.out.println("治疗效果额外增加" + String.valueOf(increase * 100) + "%");

        } else {
            System.out.println("输入数值有误，无法计算");
        }

    }
}
