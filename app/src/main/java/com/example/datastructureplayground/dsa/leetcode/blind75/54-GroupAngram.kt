package com.example.datastructureplayground.dsa.leetcode.blind75

fun main() {

    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = groupAnagram(strs)
    val result2 = groupAnagram2(strs)
    println(result)
    println(result2)

}

fun groupAnagram(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (str in strs){
        val charArray = str.toCharArray()
        charArray.sort()
        val sortedStr = String(charArray)
        map[sortedStr] = map.getOrDefault(sortedStr, mutableListOf())
        map[sortedStr]?.add(str)
    }

    return map.values.toList()
}// TC: O(n * k * log k), SC: O(n * k)

fun groupAnagram2(strs: Array<String>): List<List<String>>{
    val map = HashMap<String, MutableList<String>>()

    for(str in strs){
        val frequencyString = getFrequency(str)
        map[frequencyString] = map.getOrDefault(frequencyString, mutableListOf())
        map[frequencyString]?.add(str)

    }
    return map.values.toList()
} // TC: O(n * k), SC: O(n * k)

fun getFrequency(str: String): String {

    val charArray = str.toCharArray()
    val alphabetArray = IntArray(26)

    for (char in charArray){
        alphabetArray[char - 'a']++
    }
    var char = 'a'
    var strBuilder = StringBuilder()
    for (frequency in alphabetArray){
        if(frequency > 0){
            strBuilder.append(char)
            strBuilder.append(frequency)
        }
        char++
    }


    return strBuilder.toString()
}

/*
*
 Practice - Group Anagrams
Given an array of strings strs, group the strings that are anagrams of each other together. An anagram is a word formed by rearranging the letters of another word, using all the original letters exactly once. Return the grouped anagrams in any order. Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]



Example 2:

Input: strs = [""]

Output: [[""]]



Example 3:

Input: strs = ["a"]

Output: [["a"]]


Constraints:

1 <= strs.length <= 104

0 <= strs[i].length <= 100

strs[i] consists of lowercase English letters.

*/