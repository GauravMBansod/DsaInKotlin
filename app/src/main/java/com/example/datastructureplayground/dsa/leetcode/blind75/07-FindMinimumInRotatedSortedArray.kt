package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val min = findMinimumInSortedArray(intArrayOf(4,5,0,1,2,3))
    println("Min: $min")
}

fun findMinimumInSortedArray(nums: IntArray) : Int{

    if(nums.isEmpty()){
       return -1
    }

    when(nums.size ){
        1-> return nums[0]
        2-> return minOf(nums[0], nums[1])
    }

    if(nums[0] < nums[nums.size-1]){
        return nums[0]
    }

    var left = 0
    var right = nums.size-1



    while(left <= right) {
        val mid = left + (right - left)/2
        if (nums[mid] < nums[mid - 1]) {
            return nums[mid]
        }

        if (nums[mid] > nums[mid + 1]) {
            return nums[mid + 1]
        }

        if (nums[mid] > nums[0]) {
            left = mid + 1
        } else {
            right = mid - 1

        }
    }
    return -1

}// TC: O(log n), SC: O(1)
