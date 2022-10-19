package org.example.leetcode;

import java.util.Arrays;

public class SearchInsertIndex {
    public static void main(String[] args) {
        System.out.println(Solution.searchInsert(new int[] {1,3,5,6}, 5));
    }

    static class Solution {
        public static int searchInsert(int[] nums, int target) {
            if (nums.length == 1) {
                return target <= nums[0] ? 0 : 1;
            } else if (target <= nums[0]) {
                return 0;
            }

            int left = 0;
            int right = nums.length;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            if (nums[left] == target) {
                return left;
            }

            return left + 1;
        }
    }
}

