package br.edu.ifsp.testing.class03.exercises;

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

    public static int calculateTotalOfChocolates(double n, double c, int m) {
        if(n < 0) throw new IllegalArgumentException("n must be greater than 0");
        if(c <= 0) throw new IllegalArgumentException("c must be greater than 0");
        if(m <= 1) throw new IllegalArgumentException("m must be greater than 1");

        int purchasedChocolates = (int) (n/c);

        return purchasedChocolates + exchange(purchasedChocolates, m);
    }

    private static int exchange(int purchasedChocolates, int m) {
        if(purchasedChocolates < m) return 0;

        int extras = purchasedChocolates / m;
        int rest = purchasedChocolates % m;

        return extras + exchange(extras + rest, m);
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        final int result = calculateTotalOfChocolates(n, c, m);
        System.out.println(result);
    }
}


