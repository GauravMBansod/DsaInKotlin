package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val result = insetInterval(arrayListOf(arrayListOf(1,2), arrayListOf(3,5), arrayListOf(6,7), arrayListOf(8,10), arrayListOf(12,16)), arrayListOf(24,88))
    println(result)
}

fun insetInterval (intervals : ArrayList<ArrayList<Int>>, newInterval : ArrayList<Int>): MutableList<ArrayList<Int>> {
    val n = intervals.size
    val result = mutableListOf<ArrayList<Int>>()
    var i = 0

    // find out interval on the left of newInterval (non-overlapping)
    while (i < n && intervals[i][1] < newInterval[0]){
        result.add(intervals[i])
        i++
    }

    // merge all overlapping intervals
    while (i < n && intervals[i][0] <= newInterval[1]){
        newInterval[0] = Math.min(newInterval[0], intervals[i][0])
        newInterval[1] = Math.max(newInterval[1], intervals[i][1])
        i++
    }
    result.add(newInterval)

    // add all the remaining intervals to the right
    while (i < n) {
        result.add(intervals[i])
        i++
    }
    return result
} // TC: O(n), SC: O(1)

/*
* Practice - Insert Interval
You are given a list of non-overlapping intervals sorted by their start points. You are also given a new interval [start, end].

Insert the new interval into the list of intervals, merging any overlapping intervals if necessary. Return the updated list of intervals.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]

Output: [[1,5],[6,9]]



Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]

Output: [[1,2],[3,10],[12,16]]

Explanation: The new interval [4,8] overlaps with [3,5], [6,7], and [8,10], so they are merged into [3,10].

*/