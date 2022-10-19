package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 6, 5, 7};
        System.out.println(solve(nums));
    }

    private static String solve(int[] nums) {
        Arrays.sort(nums);
//        List<String> parts = new ArrayList<>();
        StringBuilder parts = new StringBuilder();
        if (nums.length == 0) {
            return "";
        }

        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        int start = nums[0];
        int temp = start;
        for (int i = 1; i < nums.length; i++) {
            if (++temp != nums[i]) {
                if (nums[i - 1] - start >= 1) {
//                    parts.add(String.format("%s-%s", start, nums[i - 1]));
                    parts.append(String.format("%s-%s,", start, nums[i - 1]));
                } else {
//                    parts.add(String.valueOf(start));
                    parts.append(start).append(",");
                }

                start = nums[i];
                temp = start;
            }

            if (i == nums.length - 1) {
                if (nums[i] == nums[i - 1] + 1) {
//                    parts.add(String.format("%s-%s", start, nums[i]));
                    parts.append(String.format("%s-%s", start, nums[i]));
                } else {
//                    parts.add(String.valueOf(nums[i]));
                    parts.append(nums[i]);
                }
            }
        }

        return parts.toString();
    }
}