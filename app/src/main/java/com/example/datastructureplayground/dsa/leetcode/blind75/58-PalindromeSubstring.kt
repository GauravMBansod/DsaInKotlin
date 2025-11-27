package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val count = countPalindrome("babad")
    println(count)
}

fun countPalindrome(str : String) : Int{
    var count = 0

    for(i in 1..str.length-1) {
        count += countSubString(str, i, i)
        count += countSubString(str, i, i+1)
    }
    return count
}// TC: O(n^2), SC: O(1)

fun countSubString(str: String, leftIndex: Int, rightIndex: Int): Int {

    var left = leftIndex
    var right = rightIndex

    var count = 0

     while (left >= 0 && right < str.length && str[left] == str[right]){

         count++
         left--
         right++

     }

    return count
}

/*
Practice - Palindromic Substrings
Given a string s, find and return the number of palindromic substrings it contains.

A string is considered a palindrome if it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Examples:

Input: s = "abc"

Output: 3

Explanation: Three palindromic substrings: "a", "b", "c".

Input: s = "aaa"

Output: 6

Explanation: Six palindromic substrings: "a", "a", "a", "aa", "aa", "aaa".



Constraints:

1 <= s.length <= 1000

s consists only of lowercase English letters.

*/