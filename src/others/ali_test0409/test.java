package others.ali_test0409;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {

        return "yes,0";
    }

    public static boolean isIn(List<Double> xList, List<Double> yList, double x, double y){



        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}
