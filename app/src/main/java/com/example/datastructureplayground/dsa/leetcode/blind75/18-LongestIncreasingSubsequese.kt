package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val answer = longestIncreasingSubsequence(intArrayOf(0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15))
    println("Answer: $answer")
}

fun longestIncreasingSubsequence(nums: IntArray):Int{
    var answer = 0
    val dp = IntArray(nums.size){1}

    for (i in 1 until nums.size){
        for (j in 0 until i){
            if(nums[i] > nums[j]){
                dp[i] = Math.max(dp[i], dp[j]+1)
            }
        }
        answer = Math.max(answer, dp[i])
    }
    return answer
}// TC: O(n), SC: O(n)

/*
Practice - Longest Increasing Subsequence
Given an array of integers nums, find the length of the longest (strictly) increasing subsequence from the given array.



Example 1:

Input: nums = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}

Output:  6

Explanation: There are multiple LIS in this array of same length. One of the Longest increasing subsequence is {0,2,6,9,13,15}.



Example 2:

Input: nums = {5,8,3,7,9,1}

Output:  3

Explanation: One such Longest increasing subsequence is {5,7,9}.
* */