package others.oj_njuse.problem123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[][] chess;
    public static int number = 0;
//    public static int blackX = 0;
//    public static int blackY = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int caseNum = scanner.nextInt();
            for (int c = 0; c < caseNum; c++) {
                int n = scanner.nextInt();
                int blackX = scanner.nextInt();
                int blackY = scanner.nextInt();
                int findX = scanner.nextInt();
                int findY = scanner.nextInt();
                int length = (int) Math.pow(2, n);
                chess = new int[length][length];
                chessBoard(0, 0, length, blackX, blackY);
                int findNumber = chess[findX][findY];
                List<List<Integer>> result = new ArrayList<>();
                for (int i = 0; i < length; i++) {
//                    System.out.println(Arrays.toString(chess[i]));
                    for (int j = 0; j < length; j++) {
                        if (!(i == findX && j == findY) && chess[i][j] == findNumber) {
                            result.add(Arrays.asList(i, j));
                        }
                    }
                }
                for(int i=0;i<result.size();i++){
                    if(i!=result.size() - 1){
                        System.out.print(result.get(i).get(0)+" "+result.get(i).get(1)+",");
                    }
                    else{
                        System.out.println(result.get(i).get(0)+" "+result.get(i).get(1));
                    }
                }
            }
        }
    }

    public static void chessBoard(int row, int col, int length, int blackX, int blackY) {
        if (length == 1) {
            return;
        }

        int newLength = length / 2;
        number++;
        int t = number;
        //黑点在左上部分棋盘
        if (blackX < row + newLength && blackY < col + newLength) {
            chessBoard(row, col, newLength, blackX, blackY);
        } else {
            //对右下角编号，然后将左上部分棋盘视作一个右下角为黑点的棋盘
            chess[row + newLength - 1][col + newLength - 1] = t;
            chessBoard(row, col, newLength, row + newLength - 1, col + newLength - 1);
        }

        //在右上部分
        if (blackX < row + newLength && blackY >= col + newLength) {
            chessBoard(row, col + newLength, newLength, blackX, blackY);
        } else {
            chess[row + newLength - 1][col + newLength] = t;
            chessBoard(row, col + newLength, newLength, row + newLength - 1, col + newLength);
        }
        //在左下部分
        if (blackX >= row + newLength && blackY < col + newLength) {
            chessBoard(row + newLength, col, newLength, blackX, blackY);
        } else {
            chess[row + newLength][col + newLength - 1] = t;
            chessBoard(row + newLength, col, newLength, row + newLength, col + newLength - 1);
        }
        //在右下部分
        if (blackX >= row + newLength && blackY >= col + newLength) {
            chessBoard(row + newLength, col + newLength, newLength, blackX, blackY);
        } else {
            chess[row + newLength][col + newLength] = t;
            chessBoard(row + newLength, col + newLength, newLength, row + newLength, row + newLength);
        }
    }
}
