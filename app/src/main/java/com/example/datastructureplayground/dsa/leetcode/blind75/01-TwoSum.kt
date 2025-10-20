package com.example.datastructureplayground.dsa.leetcode.blind75

/*
* 1. Two Sum
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?*/

fun main(){
    val nums = intArrayOf(2,7,11,15)
    val target = 9
    val result = twoSum(nums, target)
    println(result.contentToString())
}

fun twoSumAP1(numbs: IntArray, target: Int): IntArray {

    for (i in 0 until numbs.size) {
        for (j in i + 1 until numbs.size) {
            if (numbs[i] + numbs[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()

}

fun twoSum(numbs: IntArray, target: Int): IntArray {
    // Create a HashMap to store the numbers and their indices
    val numMap = HashMap<Int, Int>()

    // Iterate over the array
    for (i in numbs.indices) {
        // Calculate the complement needed to reach the target
        val complement = target - numbs[i]
        // If the complement is in the map, we found a solution
        if (numMap.containsKey(complement)) {
            return intArrayOf(numMap[complement]!!, i)
        }
        // Otherwise, add the current number and its index to the map
        numMap[numbs[i]] = i
    }
    // If no solution is found, return an empty array (or throw an exception, as per problem constraints)
    return intArrayOf() // Or throw IllegalArgumentException("No two sum solution")
}




