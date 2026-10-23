class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i=1; i<prices.length; i++) {
            if (prices[i-1] < prices[i]) { // if today is cheaper
            profit -= prices[i-1]; // buy today
            profit += prices[i]; // sell tmw
            }
        }
        return profit;
    }
}

// so each day we can buy stock or sell and cant hold
// so to maximize profit we can simply buy today and sell just the next day
// if we make a profit we do it otherwise we dont