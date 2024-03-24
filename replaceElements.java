//Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
//After doing so, return the array.
//Example 1:
/*
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
*/
/*
Example 2:
Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
*/

// function call for slicing and max ; time limit exceeded : O(n^2)
/* 
class Solution { 
    public int[] replaceElements(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int n = arr.length-(i+1);
            int[] arrnew = slice(arr, i+1, arr.length-1, n);
            int maxval = max(arrnew);
            arr[i] = maxval;
        }
        return arr;
    }
    public int[] slice(int[] arr, int start, int end,int n){
        int[] x = new int[n];
        if(start>end){
            return new int[]{-1};
        }
        else{
            for(int i = 0; i < n; i++){
                x[i] = arr[start + i];
                }
            return x;
        }
    }
    public int max(int[] arrnew){
        int greatest = arrnew[0];
        for(int i=0; i<arrnew.length; i++){
            if(arrnew[i]>greatest){
                greatest = arrnew[i];
            }
        }
        return greatest;
    }
}
*/

// Math Max method, Time Limit : 0(n)
class Solution { 
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int temp = arr[arr.length-1];
        for(int i= arr.length-1; i>=0; i--){
            temp = arr[i];
            arr[i] = max;
            max = Math.max(temp,max);
        }
        return arr;
    }
}
