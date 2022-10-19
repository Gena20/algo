package org.example.express.lesson1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BuySell {
    public static void main(String[] args) {
//        consoleSolution();
        stressTest();
    }

    private static void consoleSolution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var vals = new Integer[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
        }

        var solution = FastSolution.solve(n, vals);

        System.out.printf(solution);
    }

    private static void stressTest() {
        for (int j = 0; j < 10000000; j++) {
            int n = (int) (Math.random() * 10);
            var vals = new Integer[n];
            for (int i = 0; i < n; i++) {
                vals[i] = (int) (Math.random() * 5000);
            }

            var brutForceSolution = BrutForceSolution.solve(n, vals);
            var fastSolution = FastSolution.solve(n, vals);
            if (!brutForceSolution.equals(fastSolution)) {
                System.out.printf("brutForceSolution: %s\nfastSolution: %s\n", brutForceSolution, fastSolution);
                System.out.printf("n: %s\nvals: %s", n, Arrays.stream(vals).map(String::valueOf).collect(Collectors.joining(" ")));
                break;
            }
        }

        System.out.println("OK");
    }

    public static class FastSolution {
        public static String solve(int n, Integer[] vals) {
            int buyDay = 0, sellDay = 0;
            int buyIndex = 0;
            int profit = 0;

            for (int i = 0; i < n; i++) {
                if (vals[i] - vals[buyIndex] > profit) {
                    profit = vals[i] - vals[buyIndex];
                    buyDay = buyIndex + 1;
                    sellDay = i + 1;
                }

                if (vals[i] < vals[buyIndex]) {
                    buyIndex = i;
                }
            }

            return String.format("%s %s", buyDay, sellDay);
        }
    }

    public static class BrutForceSolution {
        public static String solve(int n, Integer[] vals) {
            int buyIndex = 0;
            int sellIndex = 0;
            int profit = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (vals[j] - vals[i] > profit && vals[i] < 1000) {
                        profit = vals[j] - vals[i];
                        buyIndex = i + 1;
                        sellIndex = j + 1;
                    }
                }
            }

            return String.format("%s %s", buyIndex, sellIndex);
        }
    }
}
