package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val result = mergeInterval(arrayListOf(arrayListOf(1,3), arrayListOf(2,6), arrayListOf(8,10), arrayListOf(15,18)))
    println(result)
}

fun mergeInterval(intervals : ArrayList<ArrayList<Int>> ): ArrayList<ArrayList<Int>>{

    //sort by start time
    intervals.sortBy { it[0] }

    val result = mutableListOf<ArrayList<Int>>()

    for(i in intervals){
        if(result.isEmpty() || result.last()[1] < i[0]) {
            result.add(i)
        }else{
            result.last()[1] = Math.max(result.last()[1], i[1])
        }
    }
    return result as ArrayList<ArrayList<Int>>

}// TC: O(n log n + n) SC: O(1)

/*Practice - Merge Interval
Given a list of intervals [start, end], merge overlapping intervals to create a list of non-overlapping intervals that cover all input intervals.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]

Output: [[1,6],[8,10],[15,18]]

Explanation: Intervals [1,3] and [2,6] overlap, so they are merged into [1,6].



Example 2:

Input: intervals = [[1,4],[4,5]]

Output: [[1,5]]

Explanation: Intervals [1,4] and [4,5] overlap, so they are merged into [1,5].



Constraints:

1 <= intervals.length <= 10^4

Each interval has length 2.

0 <= starti <= endi <= 10^4

*/