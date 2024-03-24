//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
/* 
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
*/
/* 
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/


// Time limit exceeded
/* 
 class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        for(int i=0; i<nums.length; i++){
           int pre =  prefixArray(0, i-1, nums);
           int suf =  suffixArray(i+1 , nums.length-1, nums);
           product[i] = pre * suf;
        }
        return product;
    }
    public int prefixArray(int start, int last, int[] nums){
        int pre = 1;
        for(int i=start; i<= last; i++){
           pre = pre * nums[i];
        }
        return pre;
    }
    public int suffixArray(int start, int last, int[] nums){
        int suf = 1;
        for(int i=start; i<= last; i++){
           suf = suf * nums[i];
        }
        return suf;
    }
}
*/

// HOW DO PEOPLE EVEN THINK THIS???
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1;
        int post = 1;
        int[] finalp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i == 0){
                finalp[i] = pre;
            }
            else{
                pre = pre * nums[i-1];
                finalp[i] = pre;
            }
        }
        for(int i=nums.length-1; i>=0; i--){
            if(i == nums.length - 1){
                finalp[i] = post * finalp[i];
            }
            else{
                post = post * nums[i+1];
                finalp[i] = finalp[i] * post;
            }
        }
        return finalp;
    }
}