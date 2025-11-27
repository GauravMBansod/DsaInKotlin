  package com.example.datastructureplayground.dsa.leetcode.blind75

fun main() {
    val isAnagram = isAnagram("anagram ", "nagaram")
    println(isAnagram)
}

fun isAnagram(s: String, t: String): Boolean {
    val map = HashMap<Char, Int>()

    // compare length
    if (s.length != t.length) return false

    for (index in 0..s.length-1) {
        map[s[index]] = map.getOrDefault(s[index], 0) + 1
        map[t[index]] = map.getOrDefault(t[index], 0) - 1
    }

    for (value in map.values) {
        if (value != 0) return false
    }

    return true

}
/*
*
Practice - Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:

Input: s = "anagram", t = "nagaram"

Output: true



Example 2:

Input: s = "rat", t = "car"

Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104

s and t consist of lowercase English letters.



Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
* */