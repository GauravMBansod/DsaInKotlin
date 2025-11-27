package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val longestSubstring = longestSubstringWithoutRepeatingChar("pwwkew")
    println(longestSubstring)
}

fun longestSubstringWithoutRepeatingChar(str: String) : Int{
    var maxLength = 0

    val hashSet = HashSet<Char>()

    var left = 0

    for(right in 0 .. str.length-1 ){

        while(hashSet.contains(str[right])){
        hashSet.remove(str[left])
        left++
        }

        hashSet.add(str[right])
        maxLength = Math.max(maxLength, hashSet.size)

    }

    return maxLength
} // TC: O(n), SC: O(n)

/*
* Practice - Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"

Output: 3

Explanation: The answer is "abc", with the length of 3.



Example 2:

Input: s = "bbbbb"

Output: 1

Explanation: The answer is "b", with the length of 1.



Example 3:

Input: s = "pwwkew"

Output: 3

Explanation: The answer is "wke", with the length of 3.

Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



Constraints:

0 <= s.length <= 5 * 104

s consists of English letters, digits, symbols and spaces.
*/