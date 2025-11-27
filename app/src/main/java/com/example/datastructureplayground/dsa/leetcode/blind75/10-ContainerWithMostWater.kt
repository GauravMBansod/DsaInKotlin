package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val maxArea = containerWithMostWater(intArrayOf(1,8,6,2,5,4,8,3,7))
    println("Max Area: $maxArea")
}

fun containerWithMostWater(heights: IntArray) : Int{
    var ans = 1
    var left = 0
    var right = heights.size-1

    while (left<right){
        val width = right-left
        val height = minOf(heights[left], heights[right])
        val area = width * height
        ans = maxOf(ans, area)
        if(heights[left] < heights[right]){
            left++
        }else{
            right--
        }
    }
    return ans
}// TC: O(n), SC: O(1)

/*
* Practice - Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]

Output: 49

Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.



Example 2:

Input: height = [1,1]

Output: 1

Constraints:

n == height.length

2 <= n <= 105

0 <= height[i] <= 104

*/