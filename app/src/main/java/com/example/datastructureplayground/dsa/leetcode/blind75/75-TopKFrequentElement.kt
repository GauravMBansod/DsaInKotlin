package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val result = topKFrequentElement(intArrayOf(1,1,1,2,2,3,3,3,3,3), 2)
    println(result)
}

fun topKFrequentElement(nums: IntArray, k: Int): ArrayList<Int> {

    // create frequency map for the array
    val frequencyMap = mutableMapOf<Int, Int>()
    for (num in nums) {
        frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
    }


    val bucketList = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }

    for (key in frequencyMap.keys) {
        val frequency = frequencyMap[key]!!
        bucketList[frequency].add(key)
    }

    val result = ArrayList<Int>()


    var count = k
    for (i in bucketList.size - 1 downTo 0) {


        if (bucketList[i].isNotEmpty()) {
            count--
            result.addAll(bucketList[i])
            if (count == 0)
                break
        }
    }
    return result
}

/*
Practice - Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]



Example 2:

Input: nums = [1], k = 1

Output: [1]



Constraints:

1 <= nums.length <= 105

-104 <= nums[i] <= 104

k is in the range [1, the number of unique elements in the array].

It is guaranteed that the answer is unique.



Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

