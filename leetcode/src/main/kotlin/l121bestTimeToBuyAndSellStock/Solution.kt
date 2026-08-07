package l121bestTimeToBuyAndSellStock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minBuyPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (price in prices) {
            if (price < minBuyPrice) {
                minBuyPrice = price
            } else {
                maxProfit = maxOf(maxProfit, price - minBuyPrice)
            }
        }
        return maxProfit
    }
}
