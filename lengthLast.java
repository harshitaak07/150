class Solution {
    public int lengthOfLastWord(String s) {
        String[] arrOfStr = s.split(" ");
        int n = arrOfStr.length;
        return arrOfStr[n-1].length();
    }
}
public class lengthLast{
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLastWord("Fly me to the moon"));
    }
}