package algorithms;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        int result = new SearchInsertPosition().new Solution().searchInsert(nums, target);
        System.out.println(result);
    }

    /**
     * A standard binary search.
     * 
     * Time complexity: O(log n)
     * Space complexity: O(1)
     */
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int start = 0;
            int end = nums.length - 1;

            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                }
            }

            if (nums[start] >= target) {
                return start;
            } else if (nums[end] >= target) {
                return end;
            } else {
                return end + 1;
            }
        }
    }

}
