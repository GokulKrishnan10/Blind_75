/*121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

APPROACH: SLIDING WINDOW, TWO POINTERS
Time Complexity:O(n)
Space Complexity:O(1)*/
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length,l=0,r=1,res=0;
        while(l<r && r<n){
            if(prices[r]<prices[l]){
                l=r;
            } 
            res=Math.max(res,prices[r]-prices[l]);
            r++;
        }
        return res;
    }
}