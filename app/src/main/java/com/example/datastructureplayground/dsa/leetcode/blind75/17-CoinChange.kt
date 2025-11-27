package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val minCoin = minCoinChange(intArrayOf(1,2,5), 11)
    println("Min Coin: $minCoin")
}

fun minCoinChange(coins: IntArray, amount: Int): Int {

    if(amount <= 0) return 0

    val minCoinDP = IntArray(amount+1){ Int.MAX_VALUE }

    minCoinDP[0] = 0

    for(amountValue in 1..amount){
        for(coin in coins){
            if(coin <= amountValue && minCoinDP[amountValue-coin] != Int.MAX_VALUE){
                minCoinDP[amountValue] = Math.min(minCoinDP[amountValue], minCoinDP[amountValue-coin]+1)
            }
        }
    }
    return if(minCoinDP[amount] == Int.MAX_VALUE) -1 else minCoinDP[amount]

}// TC: (n * amount), SC: O(amount)

/*

Practice - Coin Change
Given an integer array coins[ ] of size N representing different denominations of currency and an integer amount, find the number of ways you can make amount by using different combinations from coins array.



Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.



You may assume that you have an infinite number of each kind of coin.





Example 1:

Input: coins = [1,2,5], amount = 11

Output: 3

Explanation: 11 = 5 + 5 + 1



Example 2:

Input: coins = [2], amount = 3

Output: -1



Example 3:

Input: coins = [1], amount = 0

Output: 0



Constraints:

1 <= coins.length <= 12

1 <= coins[i] <= 231 - 1

0 <= amount <= 104
*/