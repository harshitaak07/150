// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

/*
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

/*Example 2:
Input: strs = [""]
Output: [[""]]
*/

/*Example 3:
Input: strs = ["a"]
Output: [["a"]]
*/

// FUCK IT YES BITCH; FIRST TRY RAN ALL TEST CASES IN 20 MINS , ONLY TIME LIMIT EXCEEDED. AND THIS IS A MEDIUM QUESTION
/*  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashSet<String> distinct = new HashSet<String>();
        List<List<String>> big = new ArrayList<>();
        int s = strs.length;

        for(int i=0; i<s; i++){ // SORTS WORDS ADDS IT TO HASHSET
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(!distinct.contains(sorted)){
                distinct.add(sorted);
            }  
        }

        for(String d: distinct){ // ITERATES IN HASHSET VALUES, CREATES A NEW LIST FOR EACH SET AND ADDS THE STRINSG WHICH HAD THOSE SORTED HASHSET LETTERS.
            List<String> small = new ArrayList<>();
            for(int i=0; i<s; i++){
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                if(d.equals(sorted)){
                    small.add(strs[i]);
                }
            }
            big.add(small);
        }

        return big;
    }
}
*/

// MODIFY CODE FOR TIME LIMIT EXCEEDED. // USED HASHMAP
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> big = new ArrayList<>();
        HashMap<String, List<String>> distinct = new HashMap<String, List<String>>();
        int s = strs.length;

        for(int i=0; i<s; i++){ //SORTS STRING IN ARRAY THEN ADDS IT AS KEY
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(!distinct.containsKey(sorted)){
                distinct.put(sorted, new ArrayList<>()); // VALUE IS THE LIST OF ALL WORD CONTAINING THE SORTED LETTERS
            }  
            distinct.get(sorted).add(strs[i]); // ADDS THE STRING TO VALUE LIST
        }

        for(String d: distinct.keySet()){
            big.add(distinct.get(d)); // BIG LIST
        }

        return big;
    }
}