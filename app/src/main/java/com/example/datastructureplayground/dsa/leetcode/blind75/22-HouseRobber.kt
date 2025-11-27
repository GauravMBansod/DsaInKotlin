package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){

    val maxRobbery = houseRobber(intArrayOf(2,7,9,3,1))
    println("Max Robbery: $maxRobbery")

}


fun houseRobber(numbs: IntArray): Int{
    if(numbs.isEmpty()) return 0
    if (numbs.size < 2) return numbs[0]


    var prev1 = numbs[0]
    var prev2 = Math.max(numbs[0],numbs[1])

    for (i in 2 until numbs.size) {

        numbs[i] = Math.max(numbs[i] + prev1, prev2)
        prev1 = prev2
        prev2 = numbs[i]

    }

    return numbs[numbs.size-1]
}// TC: O(n), SC: O(1)

/*
Practice - House Robber
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without robbing the adjacent houses.



Example 1:

Input: nums = [1,2,3,1]

Output: 4



Example 2:

Input: nums = [2,7,9,3,1]

Output: 12
* */