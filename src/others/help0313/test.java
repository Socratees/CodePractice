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
            double ratio = (maxBlood - myBlood)/maxBlood;
            double increase = ratio / 0.1 * 0.06;
            System.out.println("损失生命值" + String.valueOf(ratio * 100) + "%");
            System.out.println("治疗效果额外增加" + String.valueOf(increase * 100) + "%");

        } else {
            System.out.println("输入数值有误，无法计算");
        }

    }
}
