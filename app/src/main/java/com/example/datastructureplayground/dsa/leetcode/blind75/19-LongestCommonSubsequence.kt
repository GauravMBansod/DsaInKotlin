package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val longestCommonSubsequence = longestCommonSubsequence("abcde", "ace")
    println("Longest Common Subsequence: $longestCommonSubsequence")
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text1.length+1){IntArray(text2.length+1)}
    dp[0][0] = 1
    for (i in 1..text1.length){
        for (j in 1..text2.length) {
            if (text1[i-1] == text2[j-1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[text1.length][text2.length]
} // TC: O(m * n), SC: O(m * n)

/*
Practice - Longest Common Subsequence
Given two strings text1 and text2, return the length of  longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a given sequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.

For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"

Output: 3

Explanation: The longest common subsequence is "ace" and its length is 3.



Example 2:

Input: text1 = "abc", text2 = "abc"

Output: 3

Explanation: The longest common subsequence is "abc" and its length is 3.



Example 3:

Input: text1 = "abc", text2 = "def"

Output: 0

Explanation: There is no such common subsequence, so the result is 0.



* */