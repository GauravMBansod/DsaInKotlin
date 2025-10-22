package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val maxSum = findMaximumSubArray(intArrayOf(1))
    println("max sum: $maxSum")
}

fun findMaximumSubArray(intArray: IntArray):Int{
    var currentSum = intArray[0]
    var maxSum = intArray[0]

    for (num in 1 until intArray.size){
        currentSum = maxOf(num, currentSum + num)
        maxSum = maxOf(maxSum, currentSum)
    }

    return maxSum
}// TC: O(n), SC: O(1)

/*Practice - Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6

Explanation: The subarray [4,-1,2,1] has the largest sum 6.



Example 2:

Input: nums = [1]

Output: 1

Explanation: The subarray [1] has the largest sum 1.*/