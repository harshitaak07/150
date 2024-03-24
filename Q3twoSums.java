//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//Input: nums = [3,3], target = 6
//Output: [0,1]

// HASHMAP : TRIED FAILED
/*
import java.util.*;

class Solution {
    public HashMap<Integer,Integer> twoSum(Integer[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int complement = target - nums[i];
            if (sum.containsKey(complement) == false) {
                sum.put(complement, i);
            }
        }
        return sum;
    }
}
*/

//  Binary search : very complicated when array is not sorted or has duplicate values
/* 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {  // doesn't work for duplicate values cause binary search needs to be modified.
    public int[] twoSum(int[] nums, int target){
        List<int[]> fin = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int j = target - nums[i];
            int x = binarysearch(nums,j, 0, nums.length-1);
            if(x!=i && x!=-1){
                 int[] count = {i,x};
                 fin.add(count);
            }
        }
        if (fin.isEmpty()) {
            return new int[]{-1, -1}; 
        }
        int small = fin.get(0)[0];
        int other = fin.get(0)[1];
        for(int i=0; i<fin.size(); i++){
            if(fin.get(i)[0]<small){
                small = fin.get(i)[0];
                other = fin.get(i)[1];
            }
        }
        int[] ans = {small,other};
        return ans;
    }
    public int binarysearch(int[] nums, int j, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid] == j){
                return mid;
            }
            else if(nums[mid] > j){
                end = mid-1;
            }
            else if(nums[mid] < j ){
                start = mid+1;
            }
        }
        return -1;
    }
}
public class twosums {
    public static void main(String[] args) {
        int[] param_1 = {0,3,-3,4,-1};
        int param_2 = -1;
        int[] ret = new Solution().twoSum(param_1, param_2);
        System.out.println(Arrays.toString(ret));
    }
}
*/

// just use simple search lol
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target){
        List<int[]> fin = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int j = target - nums[i];
            int x = search(nums,j);
            if(x!=i && x!=-1){
                 int[] count = {i,x};
                 fin.add(count);
            }
        }
        if (fin.isEmpty()) {
            return new int[]{-1, -1}; 
        }
        int small = fin.get(0)[0];
        int other = fin.get(0)[1];
        for(int i=0; i<fin.size(); i++){
            if(fin.get(i)[0]<small){
                small = fin.get(i)[0];
                other = fin.get(i)[1];
            }
        }
        int[] ans = {small,other};
        return ans;
    }
    public int search(int[] nums, int j){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == j){
                return i;
            }   
        }
        return -1;
    }
}