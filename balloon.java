/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.
Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0
*/


// My code correct logic, wrong code.
/*
import java.util.HashMap;
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> balloon = new HashMap<>();

        Issue here is, don't create empty hashmap. because then words like lloon will have values l:2,o:2,n:1 and then 
        when you check for b , it will return null nad get null pointer exception.

        for (char ele : text.toCharArray()){
            if(ele == 'b' || ele == 'a' || ele == 'l' || ele == 'o' || ele == 'n'){
                if(!balloon.containsKey(ele)){
                    balloon.put(ele, 1);
                }
                else{
                    int count = balloon.get(ele);
                    balloon.put(ele, count+1);
                }
            }
        }

        for(char key: balloon.keySet()){
            if(key == 'l' || key == 'o'){
                balloon.put(key,balloon.get(key)/2);
            }
        }

        int number = balloon.get('b');
        for(char key: balloon.keySet()){
            if(balloon.get(key) != number){
                return 0;
            }
        }

        return number;

        The issue with this part of the code is that you're checking the equality of the counts for all characters in balloon with the count of the character 'b'. This logic assumes that 'b' will always have the maximum count, which might not be the case.
        For example, if the input text is "balloon", the counts in balloon will be:

        'b': 1
        'a': 1
        'l': 2 (divided by 2 to get 1)
        'o': 2 (divided by 2 to get 1)
        'n': 1

        So, in this case, the counts for 'l' and 'o' are also 1 (after dividing by 2), and the correct result should be 1 (the minimum count among all characters).
        To fix this, you should find the minimum count among all characters in balloon. Here's the corrected code:
    }
}
*/

// Correct way
import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> balloon = new HashMap<>();
        balloon.put('b', 0);
        balloon.put('a', 0);
        balloon.put('l', 0);
        balloon.put('o', 0);
        balloon.put('n', 0);

        for (char ele : text.toCharArray()) {
            if (ele == 'b' || ele == 'a' || ele == 'l' || ele == 'o' || ele == 'n') {
                int count = balloon.get(ele);
                balloon.put(ele, count+1);
            }
        }

        for (char key : balloon.keySet()) {
            if (key == 'l' || key == 'o') {
                balloon.put(key, balloon.get(key) / 2);
            }
        }

        int number = Integer.MAX_VALUE;
        for (char key : balloon.keySet()) {
            number = Math.min(number, balloon.get(key));
        }

        return number;
    }
}
