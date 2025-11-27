package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
 val uniquePaths = uniquePaths(3,7)
    println("Unique Paths: $uniquePaths")
}

fun uniquePaths(m: Int, n: Int) : Int{
    val numberOfWays = 0
    val dp = Array(m){IntArray(n)}

    dp[0][0] = 1

    for(i in 0 until m){
        for(j in 0 until n){
            if(i == 0 || j == 0)
                dp[i][j] = 1
            else
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        }
    }
    return dp[m-1][n-1]
} // SC : O(m * n), TC: O(m * n)


/*Practice - Unique Paths
There is a robot on an m x n grid. The robot initially located at top-left corner. The robot can move either down or right at any point of time.


Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.



Example 1:

Input: m = 3, n = 2

Output: 3

Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:

1. Right -> Down -> Down

2. Down -> Down -> Right

3. Down -> Right -> Down


Example 2:

Input: m = 3, n = 7

Output: 28



Constraints:

1 <= m, n <= 100*/