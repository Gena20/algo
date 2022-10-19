package org.example.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome(88888));
    }

    static class Solution {
        public static boolean isPalindrome(int x) {
//         String initial = String.valueOf(x);
//         String reversed = (new StringBuilder(initial)).reverse().toString();

//         return initial.equals(reversed);
            if (x < 0) {
                return false;
            } else if (x == 0) {
                return true;
            }

            int length = (int) (Math.log10(x) + 1);
            if (length == 1) {
                return true;
            }

            int start = 10;
            int end = (int) Math.pow(10, length - 1);
            int iterations = (int) Math.ceil((float) length / 2);

            for (int i = 0; i < iterations; i++) {
                int leftDigit = (x / end) % 10;
                int rightDigit = (x % start) / (int) Math.pow(10, i);
                if (leftDigit != rightDigit) {
                    return false;
                }

                end = end / 10;
                start = start * 10;
            }

            return true;
            // 12345
            // 12345 / 10000 = 1 % 10   = 1 | 12345 % 10   = 5   / 1   = 5
            // 12345 / 1000 = 12 % 10  = 2 | 12345 % 100  = 45  / 10  = 4
            // 12345 / 100 = 123 % 10 = 3 | 12345 % 1000 = 345 / 100 = 3
        }
    }
}
