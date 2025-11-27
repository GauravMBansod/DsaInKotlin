package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val missingNumber = findMissingNumber1(intArrayOf(9,6,4,2,3,5,7,0,1))
    val missingNumber2 = findMissingNumber2(intArrayOf(9,6,4,2,3,5,7,0,1))
    println("Missing Number: $missingNumber")
    println("Missing Number: $missingNumber2")
}

fun findMissingNumber1(arr: IntArray) : Int{
    val n = arr.size
    val sum = (n * (n+1))/2
    var sumOfArray = 0
    for(i in arr) {
        sumOfArray +=i
    }
    return sum - sumOfArray
}

fun findMissingNumber2(arr: IntArray): Int{
    var missingNumber = arr.size
    for (i in arr.indices) {
        missingNumber = missingNumber xor i xor arr[i]
    }
    return missingNumber
}// TC: O(n), SC: O(1)

/*
Practice - Missing Number
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3, 0, 1]

Output: 2



Example 2:

Input: nums = [0, 1]

Output: 2



Example 3:

Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]

Output: 8



Constraints:

1 <= n <= 104

0 <= nums[i] <= n

All the numbers of nums are unique.



Follow up: Solve this problem in O(n) time and O(1) space.
* */