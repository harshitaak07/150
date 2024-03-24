// Given a pattern and a string s, find if s follows the same pattern.
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
/* 
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
*/
/* 
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
*/
/* 
Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
*/


// convert strings to array -> hashMap to store element and list of indices -> compare values of keySet of maps via converting key sets to HashSet
// converion to arraylist, array, and comparison via keySet values failed.
// ArrayList and set have not ordering in values and idk what happened with arrays and when indices was being taken into account in sets. 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] patternArray = pattern.split("");
        String[] sArray = s.split(" ");

        HashMap<String, ArrayList<Integer>> patternMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> sMap = new HashMap<>();

        /* 
        ArrayList<ArrayList<Integer>> patternFinal = new ArrayList<>();
        ArrayList<ArrayList<Integer>> sFinal = new ArrayList<>();
        */

        for (int i = 0; i < patternArray.length; i++) {
            if (patternMap.containsKey(patternArray[i])) {
                patternMap.get(patternArray[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                patternMap.put(patternArray[i], indices);
            }
        }

        for (int i = 0; i < sArray.length; i++) {
            if (sMap.containsKey(sArray[i])) {
                sMap.get(sArray[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                sMap.put(sArray[i], indices);
            }
        }

        /*  ArrayList has no ordering
        for (String ele : patternMap.keySet()) {
            patternFinal.add(patternMap.get(ele));
        }

        for (String ele : sMap.keySet()) {
            sFinal.add(sMap.get(ele));
        }

        int pl = patternFinal.size();
        int sl = sFinal.size();

        if (pl != sl) {
            return false;
        } else {
            for (int i = 0; i < pl; i++) {
                if (!patternFinal.get(i).equals(sFinal.get(i))) {
                    return false;
                }
            }
            return true;
        }
        */

        /*  Array is confusing idk why
        int pl = patternMap.size();
        int sl = sMap.size();

        ArrayList<Integer>[] patternFinal = new ArrayList[pl];
        ArrayList<Integer>[] sFinal = new ArrayList[sl];

         int index = 0;
        for (String ele : patternMap.keySet()) {
            patternFinal[index++] = patternMap.get(ele);
        }

        index = 0;
        for (String ele : sMap.keySet()) {
            sFinal[index++] = sMap.get(ele);
        }

        System.out.println(patternFinal);
        System.out.println(sFinal);

        if (pl != sl) {
            return false;
        } else {
            for (int i = 0; i < pl; i++) {
                if (patternFinal[i] != (sFinal[i])) {
                    return false;
                }
            }
            return true;
        }
        */ 

        // return patternMap.keySet().equals(sMap.keySet()); // only compares sets not indices of values of sets
        /* idk why weird
        return compareMaps(patternMap, sMap);
        
    }
       private boolean compareMaps(HashMap<String, ArrayList<Integer>> map1, HashMap<String, ArrayList<Integer>> map2) {
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        for (String key : map1.keySet()) {
            if (!map1.get(key).equals(map2.get(key))) {
                return false;
            }
        }

        return true;
    }
    */

    // Get the values from the HashMaps
        HashSet<ArrayList<Integer>> values1 = new HashSet<>(patternMap.values());
        HashSet<ArrayList<Integer>> values2 = new HashSet<>(sMap.values());

        // Compare the values
        boolean areValuesEqual = values1.equals(values2);

        // Print the result
        if (areValuesEqual) {
            return true;
        } 
        return false;
    }
}
