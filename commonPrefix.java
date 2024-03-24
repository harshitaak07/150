// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
/*Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
// We don't know the number of elements in the array, comparison with each would be very inefficient.
// better : to sort the array, then compare first and last words.
import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String fin = "";
        int n = strs.length;
        int i=0, j=0;
        while(i<strs[0].length() && j<strs[n-1].length()){
            if(strs[0].charAt(i) == strs[n-1].charAt(j)){
                fin += strs[0].charAt(i);
                i++;
                j++;
            }
            else{
                break;
            }
        }
        return fin;
    }
}