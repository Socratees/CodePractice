package algorithm.eightQueen;

/**
 * @Description: N皇后问题的递归回溯算法求解
 * @Param: max为N
 * @Return: 输出结果数
 * @Author: liuzhibiao
 * @Date: 2019/1/1
 */
public class EightQueen {
    private static final int max = 8;
    static int[] queen = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        search(0);
        System.out.println(count);
    }

    public static boolean check(int n) {// 检查当前列能否放置皇后
        for (int i = 0; i < n; i++) {
            if (queen[i] == queen[n] || Math.abs(queen[i] - queen[n]) == (n - i)) {
                return false;
            }
        }
        return true;
    }

    public static void search(int n) {// 回溯尝试皇后位置,n为横坐标
        for (int i = 0; i < max; i++) {
            queen[n] = i;// 将皇后摆到当前循环到的位置
            if (check(n)) {
                if (n == max - 1) {// 如果全部摆好，输出所有皇后的坐标
                    count++;
//                    printer();
                    return;
                } else {
                    search(n + 1);//否则继续查找下一个皇后
                }
            }
        }
    }

    public static void printer(){
        System.out.print("[");
        for(int i=0;i<max;i++){
            System.out.print(queen[i]);
            if(i!=max-1){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}
