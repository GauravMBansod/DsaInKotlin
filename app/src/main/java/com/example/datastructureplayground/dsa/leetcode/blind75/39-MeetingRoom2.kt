package com.example.datastructureplayground.dsa.leetcode.blind75

import java.util.PriorityQueue

fun main(){
    val result = minMeetingRoomsRequired(arrayOf(Interval(0,5), Interval(1,3), Interval(2,6), Interval(6,9), Interval(15,20)))
    println("result: $result")
}
data class Interval(val start: Int, val end: Int)
fun minMeetingRoomsRequired(intervals: Array<Interval>): Int {
    intervals.sortBy { it.start }
    val minHeap = PriorityQueue<Interval>(Comparator { a, b -> a.start - b.start })
    minHeap.add(intervals[0])

    for (i in 1 until intervals.size) {
        val end = minHeap.peek()?.end ?: 0
        val start = intervals[i].start
        if (end <= start) {
                minHeap.poll()
        }
        minHeap.add(intervals[i])

    }
    return minHeap.size

}// TC: O(n log n), SC: O(n)

/*Practice - Meeting Rooms II
Given a list of meeting time intervals where each interval contains a start and end time, determine the minimum number of conference rooms required to hold all the meetings without overlap.



Each room can host one meeting at a time.



Example 1:

Input: [[0, 30], [5, 10], [15, 20]]

Output: 2



Example 2:

Input: [[7, 10], [2, 4]]

Output: 1
*/