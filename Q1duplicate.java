//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
/* 
Example 1:
Input: nums = [1,2,3,1]
Output: true
*/
/* 
Example 2:
Input: nums = [1,2,3,4]
Output: false
*/
/* 
Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
*/


// MY SOLUTION : TIME COMPLEXITY IS O(n^2); SPACE COMPLEXITY IS O(1). TOO BIG
/* 
class Solution {
    public static boolean containsDuplicate(int[] nums) {
        int[] co = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            co[i] = count;
        }
        boolean hasdup = false;
        for (int i = 0; i < nums.length; i++) {
            if (co[i] > 1) {
                hasdup = true;
                break;
            }
        }
        if (hasdup) {
            return true;
        } else {
            return false;
        }
    }
}
*/

// BETTER SOLUTION IS TO SORT : TIME COMPLEXITY IS O(nlogn); SPACE COMPLEXITY IS O(1). 
// EVEN BETTER USING HASHSET : TIME COMPLEXITY IS O(n); SPACE COMPLEXITY IS O(n). 
import java.util.HashSet;
class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
           if(set.contains(nums[i])){
            return true;
           }
           set.add(nums[i]);
        }
    return false;
    }
}

// Other via hash map
/*
 import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i : nums) {
            if (set.containsKey(i)) {
                int val = set.get(i)+1;
                set.put(i, val);
            } else {
                set.put(i, 1);
            }
        }
        for (int key : set.keySet()) {
            if (set.get(key) >= 2) {
                return true;
            }
        }
        return false;
    }
}
 */