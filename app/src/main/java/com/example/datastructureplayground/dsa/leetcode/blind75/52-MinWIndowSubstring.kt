package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    var minWindow = minWindowSubstring("ADOBECODEBANC", "ABC")
    println(minWindow)
}

fun minWindowSubstring(s: String, t: String): String {
    //hashMap of t char
    val rCount = HashMap<Char, Int>()
    for (char in t) {
        rCount.put(char, rCount.getOrDefault(char, 0) + 1)
    }

    //hashMap of s char
    val wCount = HashMap<Char, Int>()
    var count = 0


    // indexes to determine the window size
    var leftIndex = -1
    var rightIndex = -1

    var left = 0
    var right = 0
    var minLength = Int.MAX_VALUE


    while (right < s.length) {

        val char = s[right]
        wCount.put(char, wCount.getOrDefault(char, 0) + 1)
        if (rCount.containsKey(char) && wCount[char] == rCount[char]) {
            count++
        }

        while (count == rCount.size) {


            if (right - left + 1 < minLength) {
                minLength = right - left + 1
                leftIndex = left
                rightIndex = right
            }

            minLength = Math.min(minLength, right - left + 1)

            val leftChar = s[left]
            val leftCharCount = wCount.getOrDefault(leftChar,0)
            wCount[leftChar] = if(leftCharCount == 0) 0 else leftCharCount - 1

            if (rCount.containsKey(leftChar) && (wCount[leftChar] ?: 0) < (rCount[leftChar] ?: 0)) {
                count--
            }
            left++
        }

        right++

    }

    if (leftIndex == -1) return ""

    return s.substring(leftIndex, rightIndex + 1)

} // TC: O(n) + O(m), SC: O(n) + O(m)
/*Practice - Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".



The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"

Output: "BANC"

Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.



Example 2:

Input: s = "a", t = "a"

Output: "a"

Explanation: The entire string s is the minimum window.



Example 3:

Input: s = "a", t = "aa"

Output: ""

Explanation: Both 'a's from t must be included in the window.

Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length

n == t.length

1 <= m, n <= 105

s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?

*/
