/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

*/

// * MY SOLUTION: Time limit exceeded
/*
 * algorithm:
 * 1. Initialise hashmap to store buyPrice and sellPrice
 * 2. Initialise a loop, each element is buyPrice
 * 3. For each buyPrice search sellPrice by taking out maximum Price in array i+1,n-1: remove problem that stock should be sold only after buying
 * 4. Now as hashMap updates values, we need to find maximum value at once and then not search again for same element; ex [2,8,6,3,2,6] will store (2,6) and (2,8)
 *      for above do !store.containsKey(prices[i])
 */
/*
import java.util.HashMap;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        HashMap<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!store.containsKey(prices[i])){
                int buyPrice = prices[i];
                int sellPrice = search(i + 1, n - 1, prices);
                if (sellPrice > buyPrice) {
                    store.put(buyPrice, sellPrice);
                }
        }
        }
        int maxProfit = 0;
        for (HashMap.Entry<Integer, Integer> entry : store.entrySet()) {
            System.out.println(entry); 
            int buyPrice = entry.getKey();
            int sellPrice = entry.getValue();
            if ((sellPrice - buyPrice) > maxProfit) {
                maxProfit = sellPrice - buyPrice;
            }
        }

        return maxProfit;
    }
    public int search(int start, int end, int[] prices) {
        int maxPrice = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        return maxPrice;
    }
}
*/


// * BETTER SOLUTION: Time complexity O(n); Space complexity O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE; 
        int maxProfit = 0; 
        
        for (int price : prices) {
            minBuyPrice = Math.min(minBuyPrice, price); 
            maxProfit = Math.max(maxProfit, price - minBuyPrice); 
        }
        
        return maxProfit;
    }
}
