package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    var longestPalindromeSubstring = longestPalindromeSubstring("babmadamad")
    println(longestPalindromeSubstring)
}

fun longestPalindromeSubstring(str : String): String {

    if(str.length < 2) return str

    var longestPalindromeString = ""

    for(i in 1..str.length-1){
        var left = i
        var right = i

        while( left >= 0 && right < str.length && str[left] == str[right] ){
            left--
            right++
        }
        if(longestPalindromeString.length < str.substring(left+1,right).length) {
            longestPalindromeString = str.substring(left + 1, right)
        }

        // for even size of palindrome
        left =  i-1
        right = i
        while(left >= 0 && right < str.length && str[left] == str[right] ){
            left--
            right++
        }
        if(longestPalindromeString.length < str.substring(left+1,right).length) {
            longestPalindromeString = str.substring(left + 1, right)
        }
    }

    return longestPalindromeString
}

/*
Practice - Longest Palindromic Substring
Given a string s, find and return the longest palindromic substring within s.

Examples:

Input: s = "babad"

Output: "bab"

Explanation: "aba" is also a valid palindromic substring.

Input: s = "cbbd"

Output: "bb"

Constraints:

1 <= s.length <= 1000

s consists only of digits and English letters.*/