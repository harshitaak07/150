
// Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements. 
// You may return the answer in any order.

/*Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
*/

/* 
Example 2:
Input: nums = [1], k = 1
Output: [1]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    int[] result = new int[k];
    HashMap<Integer, Integer> count = new HashMap<>();
    

    for(int i=0; i<nums.length; i++){ // stored count of each element in hash map
        count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
    }

    /* 
    for (int key : count.keySet()){ // stored count in arraylist
        array.add(count.get(key));
    }

    Collections.sort(array, Collections.reverseOrder()); // sort the array list  

    for(int i=0; i<k; i++){
        result[i] = count.getKey(array.get(i));
    }

    NOT A GOOD APPROACH BECAUSE , THIS WILL SORT THE VALUES BUT LET SAY TWO KEYS HAVE SAME VALUES THEN RETRIEVAL OF KEYS WOULD BE DIFFICULT.
    EXAMPLE: [3,3,2] = SORTED ARRAY, NOW DIFFICULT TO RETRIEVE.
    */

    // Convert the HashMap entries to a List
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(count.entrySet());

        // Sort the List based on values
        entryList.sort(Map.Entry.comparingByValue());

        for(int i=0; i<k; i++){
            result[i] = entryList.get(i).getKey();
    }
    return result;
    }
}

