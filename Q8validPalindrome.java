//Given a string s, return true if it is a palindrome, or false otherwise.
/*
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

/* 
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
*/

/*
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase(); // convert string to lowercase
        List<Character> correct = new ArrayList<>(); // arraylists for correct order and reverse order
        List<Character> reverse = new ArrayList<>();
        for(int i=0; i<lower.length(); i++){ // only alphanumeric characters
            if(Character.isLetterOrDigit(lower.charAt(i))){
                correct.add(lower.charAt(i));
            }
        }
        for(int i=lower.length()-1; i>=0; i--){
            if(Character.isLetterOrDigit(lower.charAt(i))){
                reverse.add(lower.charAt(i));
            }
        }
        
        return correct.equals(reverse); // check equality
    }
}


