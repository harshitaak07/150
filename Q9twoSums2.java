/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

 

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */



// Time limit exceeded cause linear search instead of binary

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public int[] twoSum(int[] numbers, int target) {
//         List<Integer> ele = new ArrayList<>();
//         for(int i=0; i<numbers.length; i++){
//             int j = target - numbers[i];
//             int x = search(numbers,j);// binary search to reduce time complexity
//             if(x!=i && x!=-1){
//                  ele.add(i+1);
//                  ele.add(x+1);
//                  break;
//             }
//         }
//         if(ele.get(0) > ele.get(1)) {
//             int temp = ele.get(0);
//             ele.set(0, ele.get(1));
//             ele.set(1, temp);
//         }
//         return ele.stream().mapToInt(i->i).toArray();
//         // OR
//         /*
//         int[] result = new int[ele.size()];
//         for(int i = 0; i < ele.size(); i++) {
//             result[i] = ele.get(i);
//         }
//         return result;
//          */
//     }
//         public int search(int[] nums, int j){
//             for(int i=0; i<nums.length; i++){
//                 if(nums[i] == j){
//                     return i;
//                 }   
//             }
//             return -1;
//         }
        
//     }

// Binary search
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        List<Integer> ele = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            int j = target - numbers[i];
            int x = binarySearch(numbers, j, i + 1, numbers.length - 1);
            if(x != -1) {
                ele.add(i + 1);
                ele.add(x + 1);
                break;
            }
        }
        if(ele.get(0) > ele.get(1)) {
            int temp = ele.get(0);
            ele.set(0, ele.get(1));
            ele.set(1, temp);
        }
        return ele.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int binarySearch(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}


