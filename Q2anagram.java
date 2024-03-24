/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/
/* 
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
*/
/* 
Example 2:
Input: s = "rat", t = "car"
Output: false
*/
// MY SOLUTION : QUICK SORTING, Time complexity: high
/* 
class anagram{ 
    public static boolean isAnagram(String s, String t){
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        if(sArray.length!= tArray.length){
            return false;
        }
        else{
        quick(sArray, 0, sArray.length-1 );
        quick(tArray, 0, tArray.length-1 );
        for(int i=0; i<sArray.length; i++){
            if(sArray[i] != tArray[i]){
                return false;
            }
        }
        return true;
        }
    }
    public static void quick(char[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr,low,high);
            quick(arr,low,pivot-1);
            quick(arr,low+1,high);
        }
    }
    public static int partition(char[] arr, int low, int high){
        char pivot_char = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j] < pivot_char){
                i++;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        char temp = arr[i];
        arr[i] = pivot_char;
        arr[high] = temp;
        return i;
    }
}
*/

// BETTER WAY : HASHMAP 
import java.util.HashMap;


class Q2anagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> alphabets = new HashMap<>();
        HashMap<Character, Integer> alphabett = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        } else {
            for (int i = 0; i <= s.length() - 1; i++) {
                if (alphabets.containsKey(s.charAt(i))) {
                    int count = alphabets.get(s.charAt(i));
                    alphabets.put(s.charAt(i), ++count);
                } else {
                    alphabets.put(s.charAt(i), 1);
                }
            }
            for (int i = 0; i <= t.length() - 1; i++) {
                if (alphabett.containsKey(t.charAt(i))) {
                    int count = alphabett.get(t.charAt(i));
                    alphabett.put(t.charAt(i), ++count);
                } else {
                    alphabett.put(t.charAt(i), 1);
                }
            }
            if (alphabets.equals(alphabett)) {
                return true;
            } else {
                return false;
            }
        }

    }
}