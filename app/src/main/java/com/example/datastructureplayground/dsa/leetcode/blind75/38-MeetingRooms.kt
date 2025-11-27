package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val canAttend = canAttendMeetings(arrayOf(intArrayOf(7,10), intArrayOf(2,4)))
    println("can attend all meetings $canAttend")

}

fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
    intervals.sortBy { it[0] }
    var prev = 0
    for (i in 1..intervals.size-1){
        if(intervals[i][0] >= intervals[prev][1]) {
            prev = i
        }else{
            return false
        }
    }

    return true
}

/*
* Practice - Meeting Rooms
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.



NB: (0,8),(8,10) is not conflict at 8


Example 1:

Input: [[0,30],[5,10],[15,20]]

Output: false



Example 2:

Input: [[7,10],[2,4]]

Output: true

*/