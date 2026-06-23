1class Solution {
2    public int maxProfit(int[] prices) {
3        // Edge case: if there are no prices or only one day, no profit can be made
4        if (prices == null || prices.length < 2) {
5            return 0;
6        }
7
8        int minPrice = Integer.MAX_VALUE; // Track the lowest price seen so far
9        int maxProfit = 0;                // Track the maximum profit achieved
10
11        for (int i = 0; i < prices.length; i++) {
12            if (prices[i] < minPrice) {
13                // Found a new historical low price, update it
14                minPrice = prices[i];
15            } else if (prices[i] - minPrice > maxProfit) {
16                // Selling today yields a better profit than our previous max
17                maxProfit = prices[i] - minPrice;
18            }
19        }
20
21        return maxProfit;
22    }
23}