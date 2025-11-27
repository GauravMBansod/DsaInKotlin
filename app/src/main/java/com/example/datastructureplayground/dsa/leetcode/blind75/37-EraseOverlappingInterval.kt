package com.example.datastructureplayground.dsa.leetcode.blind75



fun main(){
    val result = eraseOverlappingInterval(arrayListOf(arrayListOf(1,2),
        arrayListOf(2,3), arrayListOf(3,4), arrayListOf(1,3)))
    println(result)

}

fun eraseOverlappingInterval(intervals: ArrayList<ArrayList<Int>>) : Int{
    intervals.sortBy { it[1] }
    var count = 0
    var prev = 0

    for (curr in 1..intervals.size-1){
        if(intervals[curr][0] >= intervals[prev][1]) {
            prev = curr
        }else{
            count++
        }
    }
    return count
}// TC: O(n log n + n), SC: O(1)

/*
* Practice - Non-overlapping Intervals
Given a list of intervals [start, end], find the minimum number of intervals needed to remove to make the remaining intervals non-overlapping.



Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]

Output: 1

Explanation: Removing [1,3] makes the rest non-overlapping.



Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]

Output: 2

Explanation: Need to remove two [1,2] to make the rest non-overlapping.



Example 3:

Input: intervals = [[1,2],[2,3]]

Output: 0

Explanation: No removal needed since intervals are already non-overlapping.



Constraints:

1 <= intervals.length <= 10^5

Each interval has length 2: starti and endi

-5 * 10^4 <= starti < endi <= 5 * 10^4
* */