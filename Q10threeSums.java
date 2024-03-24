/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation: 
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.
    
    Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

    Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
*/



// Takes duplicate cases like [-1,0,1] and [0,-1,1] into account
/*
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finalArray = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> triple = new ArrayList<>();
            int a = nums[i];
            int target = 0 - nums[i];
            if (set.contains(a)) {
                continue;
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    int b = nums[j];
                    int c = target - nums[j];
                    int x = binarySearch(nums, c, j + 1, nums.length - 1);
                    if (x != -1) {
                        triple.add(a);
                        triple.add(b);
                        triple.add(c);
                        finalArray.add(triple);
                        break;
                    }
                }
            }
            set.add(a);
        }
        return finalArray;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
*/

// Better to use double pointer intead of binary search
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1, target = -nums[i];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++; // let say 12245667 and left = index 1 and right = index 6, so we do left++ 
                        // and right-- this ignores 2 at index 1 and directly takes 2 at index 2. Same with the right part.
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) { // we do this as because the sum is less than the target we need a greater number which we don't get on leftmost side.
                        left++;
                    } else { // we do this as because the sum is greater than the target we need a smaller number which we don't get on rightmost side.
                        right--;
                    }
                }
            }
        }
        return result;
    }
}