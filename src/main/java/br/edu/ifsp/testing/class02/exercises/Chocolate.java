package br.edu.ifsp.testing.class02.exercises;

import java.util.Scanner;

public class Chocolate {
//     example to correct
//    public int calculateTotalOfChocolates(double n, double c, int m){
//        if (c > n){
//            return 0;
//        } else if (c == n) {
//            return 1;
//        } else {
//            int r = (int) (n / c);
//            if (r >= m){
//                return r + (r / m);
//            }
//            return r;
//        }
//    }

    public int calculateTotalOfChocolates (double n, double c, int m) {

        if(m <= 1) throw new IllegalArgumentException("M must be greater than 1");
        if(c <= 0) throw new IllegalArgumentException("C must be greater than 0");
        if(n < 0) throw new IllegalArgumentException("N must be greater than or equal to 0");

        if (c > n) return 0;

        int chocolates = (int) (n / c);

        return chocolates + exchangeWrappers(chocolates, m);

    }

    private int exchangeWrappers(int wrappers, int m) {

        if(wrappers < m) {
            return 0;
        }

        int extras = wrappers / m;
        int remaining = extras + (wrappers % m);


        return extras + exchangeWrappers(remaining, m);

    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        final int result = new Chocolate().calculateTotalOfChocolates(n, c, m);
        System.out.println(result);
    }
}


