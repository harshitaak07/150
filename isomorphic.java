import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        String[] sArray = s.split("");
        String[] tArray = t.split("");

        HashMap<String, ArrayList<Integer>> sMap = new HashMap<>();
        HashMap<String, ArrayList<Integer>> tMap = new HashMap<>();

        for (int i = 0; i < sArray.length; i++) {
            if (sMap.containsKey(sArray[i])) {
                sMap.get(sArray[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                sMap.put(sArray[i], indices);
            }
        }

        for (int i = 0; i < tArray.length; i++) {
            if (tMap.containsKey(tArray[i])) {
                tMap.get(tArray[i]).add(i);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(i);
                tMap.put(tArray[i], indices);
            }
        }

        HashSet<ArrayList<Integer>> values1 = new HashSet<>(sMap.values());
        HashSet<ArrayList<Integer>> values2 = new HashSet<>(tMap.values());

        // Compare the values
        boolean areValuesEqual = values1.equals(values2);

        // Print the result
        if (areValuesEqual) {
            return true;
        } 
        return false;
    }
}