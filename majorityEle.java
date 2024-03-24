
// Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array.
/* 
Example 1:
Input: nums = [3,2,3]
Output: 3
*/
/* 
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int ele : nums){
            if(set.containsKey(ele)){
                set.put(ele, set.get(ele)+1);
            }
            else{
                set.put(ele, 1);
            }
        }

        int greatest = 0;
        int max_no = 0;
        for (int key : set.keySet()){
            if(set.get(key)> greatest){
                greatest = set.get(key);
                max_no = key;
            }
        }

        return max_no;
    }
}