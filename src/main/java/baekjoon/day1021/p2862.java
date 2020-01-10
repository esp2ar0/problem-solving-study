package baekjoon.day1021;


import java.util.Scanner;

/**
   수학 게임
 실패...
 */
public class p2862 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = Long.parseLong(scanner.nextLine());

        if(N % 3 == 0) {
            System.out.println(N / 3 - 1);
        } else {
            System.out.println(N / 3);
        }
    }
}
