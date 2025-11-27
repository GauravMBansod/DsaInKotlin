package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val longestSubstring = longestSubstringRepeatingCharReplacement("ABAB",2)
    println(longestSubstring)
}

fun longestSubstringRepeatingCharReplacement(str: String, k : Int) : Int {

    var maxFrequency = 0
    val frequency = IntArray(26)

    var left = 0
    var maxWindowSize = 0

    for(right in str.indices){
        
        frequency[str[right]-'A']++
        val windowSize = right-left+1

        maxFrequency = maxOf(maxFrequency, frequency[str[right]-'A'])
        if(windowSize-maxFrequency > k){
            frequency[str[left]-'A']--
            left++
        }

        maxWindowSize = maxOf(maxWindowSize, right-left+1)

    }

    return maxWindowSize
} // TC: O(n), SC: O(26) ~ O(1)

/*

Link - https://www.youtube.com/watch?v=ExY8svHF_Eo

Practice - Longest Repeating Character Replacement
You are given a string s and a non-negative integer k. You can change at most k characters in the string s to any other uppercase English letter. Your goal is to find the length of the longest substring in s that contains the same letter after performing these operations.



Examples:

Input: A string s = "ABAB" and k = 2.

You can replace both 'A's with 'B's or vice versa.

The longest substring with the same letter would be "BBBB" of length 4.

Input: A string s = "AABABBA" and k = 1.

You can replace the middle 'A' with 'B', forming "AABBBBA".

The longest substring with the same letter would be "BBBB" of length 4.



Constraints:

The length of s is between 1 and 105.

s consists only of uppercase English letters.

k is a non-negative integer between 0 and the length of s.
* */


