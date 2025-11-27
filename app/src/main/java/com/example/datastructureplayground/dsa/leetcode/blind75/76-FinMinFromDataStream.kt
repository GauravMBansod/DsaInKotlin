package com.example.datastructureplayground.dsa.leetcode.blind75

import java.util.PriorityQueue

fun main(){
    val result = findMedian(intArrayOf(1,2,3,5,6))
    println(result)
}

fun findMedian(dataSet: IntArray): Double {
    val minHeap = PriorityQueue<Int>(){a:Int, b:Int -> a - b}
    val maxHeap = PriorityQueue<Int>(){a:Int, b:Int -> b - a}

    //add number
    for (num in dataSet){
        minHeap.add(num)
        maxHeap.add(minHeap.poll())
        if (maxHeap.size > minHeap.size){
            minHeap.add(maxHeap.poll())
        }
    }

    return if (minHeap.size > maxHeap.size) {
        minHeap.peek()!!.toDouble()
    }
    else {
        (maxHeap.peek()!!+minHeap.peek()!!) /2.0
    }
}

/*
Practice - Find Median From Data Stream
Design a MedianFinder class to find the median of a data stream:

MedianFinder(): Initializes the MedianFinder object.

void addNum(int num): Adds the integer num from the data stream to the data structure.

double findMedian(): Returns the median of all elements added so far. If the size of the list is even, returns the mean of the two middle values.



Example:



plaintextCopy code
Input:
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]

Output:
[null, null, null, 1.5, null, 2.0]

Explanation:
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // Add 1 to stream
medianFinder.addNum(2);    // Add 2 to stream
medianFinder.findMedian(); // Returns 1.5 (average of 1 and 2)
medianFinder.addNum(3);    // Add 3 to stream
medianFinder.findMedian(); // Returns 2.0


Constraints:

Numbers range from -10^5 to 10^5.

At least one number in the stream before finding the median.

Maximum of 5 * 10^4 calls to addNum and findMedian.
* */