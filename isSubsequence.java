//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
/* 
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
*/
/* 
Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
*/


// finding index and comapring with sorted index list
// weird code , has a lot of problem when character is used instead of String and when indices and sorted indices are compared.
// also won't work for all test cases
/* 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Some { 
    public boolean isSubsequence(String s, String t) {
        String[] sArray = s.split("");
        String[] tArray = t.split("");
        List<String> al = new ArrayList<>(Arrays.asList(tArray));
        int n = sArray.length;
        String[] indices = new String[n];
        for (int i = 0; i < n; i++) {
            if (al.contains(sArray[i])) {
                int j = al.indexOf(sArray[i]);
                indices[i] = String.valueOf(j);
            } else {
                return false;
            }
        } 
        return true;
    }
}
public class issubsequence{
    public static void main(String[] args){
        Some sol = new Some();
        System.out.println(sol.isSubsequence("abc", "ahcgdb"));
    }
}
*/

// Two Pointers
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i == s.length();
    }
}