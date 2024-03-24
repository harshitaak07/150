// You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, 
// and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
/* 
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
*/
/* 
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
*/

// My solution although correct logic , framing ia not right.
/* 
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int count = 0;
        for (int i = 0; i < l; i++) { // blocking the places where flowers can't be planted
            if (i == 0 && flowerbed[i] == 1) {
                flowerbed[i + 1] = 2;
            } else if (i != 0 && i != l - 1 && flowerbed[i] == 1) {
                flowerbed[i + 1] = 2;
                flowerbed[i - 1] = 2;
            } else if (i == l - 1 && flowerbed[i] == 1) {
                flowerbed[i - 1] = 2;
            }
        }

        for (int i = 0; i < l; i++) {
            if (i == 0 && flowerbed[i] == 0) {
                flowerbed[i + 1] = 2;
            } else if (i != 0 && i != l - 1 && flowerbed[i] == 0) {
                flowerbed[i + 1] = 2;
                flowerbed[i - 1] = 2;
            } else if (i == l - 1 && flowerbed[i] == 0) {
                flowerbed[i - 1] = 2;
            }
        }

        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {
                count++;
            }
        }

        if (count >= n) {
            return true;
        }
        return false;
    }
}
*/

// Greedy solution
// out of bounds not efficient
/* 
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int count = 0;
        if((l==1 && flowerbed[0]==0 && n==1) || (l==1 && flowerbed[0]==1 && n==0)){
            return true;
        }
        else if((l==1 && flowerbed[0]==1) || (l==1 && n>=1)){
            return false;
        }
        else if(l>=1){
        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                } else if (i != 0 && i != l - 1 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                } else if (i == l - 1 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        }
        return count >= n;
    }
}
*/

// Most effeicient solution
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int count = 0;

        for (int i = 0; i < l; i++) {
            if (flowerbed[i] == 0) {
                // Check if the current position and adjacent positions are also 0 or out of bounds
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == l - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;  // Plant a flower
                    count++;
                }
            }
        }

        return count >= n;
    }
}
