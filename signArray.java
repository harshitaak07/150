class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==0 ){
                return 0;
            }
            if(nums[i] <0){
                product = product * -1;
            }
        }
        return product;
    }
}

// No idea why other did not work.