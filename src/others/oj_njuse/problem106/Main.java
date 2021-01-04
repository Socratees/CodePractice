package others.oj_njuse.problem106;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                long strength = scanner.nextLong();
                long count = 1;
                while (strength > 0) {
                    strength -= count * count;
                    count++;
                }
                if(strength == 0){
                    count -=1;
                }else{
                    count -= 2;
                }
                System.out.println(count);
            }
        }
    }
}
