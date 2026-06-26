1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices == null || prices.length < 2) {
4            return 0;
5        }
6
7        int maxProfit = 0;
8
9        // Accumulate profit for every upward movement
10        for (int i = 1; i < prices.length; i++) {
11            if (prices[i] > prices[i - 1]) {
12                maxProfit += prices[i] - prices[i - 1];
13            }
14        }
15
16        return maxProfit;
17    }
18}
19