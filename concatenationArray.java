public class concatenationArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newArray = new int[2*n];
        for(int i=0; i<=n-1; i++){
            newArray[i] = nums[i];
        }
        for(int i=n; i<=2*n-1; i++){
            newArray[i] = nums[i-n];
        }
        return newArray;
    }
}

