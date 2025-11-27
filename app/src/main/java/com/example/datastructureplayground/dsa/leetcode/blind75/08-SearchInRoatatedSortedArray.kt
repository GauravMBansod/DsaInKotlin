package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
val searchedTarget = searchInRotatedSortedArray(intArrayOf(4,5,6,7,0,1,2), 5)
    println("Target is at index: $searchedTarget")
}

fun searchInRotatedSortedArray(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            nums[mid] == target -> return  mid
            // Left sorted portion
            nums[left] <= nums[mid] -> {
                if (target >= nums[left] && target < nums[mid]) { // Changed <= to < for mid
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            // Right sorted portion
            else -> {
                if (target > nums[mid] && target <= nums[right]) { // Changed >= to > for mid
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
    }
    return -1
} // TC: O(log n), SC: O(1)


/*Practice - Search in Rotated Sorted Array
You are given an integer array nums that is initially sorted in ascending order with distinct values. However, nums may have been rotated at an unknown pivot index k (where 1 <= k < nums.length). This rotation rearranges the elements to create a new array: [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For instance, [0,1,2,4,5,6,7] could be rotated at pivot index 3 to produce [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, your task is to find the index of target in nums. If target is not in nums, return -1.

Your solution must have a runtime complexity of O(log n).



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0

Output: 4



Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3

Output: -1



Example 3:

Input: nums = [1], target = 0

Output: -1



Constraints:

1 <= nums.length <= 5000

-10^4 <= nums[i] <= 10^4

All elements in nums are unique.

nums is an ascending array that might have been rotated.

-10^4 <= target <= 10^4

*/