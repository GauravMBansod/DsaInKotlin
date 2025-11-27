package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val traversal = spiralMatrixTraversal(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))
    for (j in traversal){
        print("$j ")
    }
} // TC: O(m * n), SC: O(m * n)



fun spiralMatrixTraversal(matrix: Array<IntArray>): List<Int> {
    // 1. Return an empty list for an empty matrix to prevent crashes.
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return emptyList()
    }

    val result = mutableListOf<Int>()
    var top = 0
    var bottom = matrix.size - 1
    var left = 0
    var right = matrix[0].size - 1

    while (top <= bottom && left <= right) {
        // 2. Traverse Right (inclusive range)
        for (i in left..right) {
            result.add(matrix[top][i])
        }
        top++

        // 3. Traverse Down
        for (i in top..bottom) {
            result.add(matrix[i][right])
        }
        right--

        // 4. Check if there's a row/column left to traverse
        if (top <= bottom) {
            // Traverse Left
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--
        }

        if (left <= right) {
            // Traverse Up
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }
    return result
}

/*
* Practice - Spiral Order Traversal [Spiral Matrix]
Given a matrix of size m x n, return its elements in spiral order.

Example 1:




Input:
matrix = [
           [1,2,3]
           [4,5,6]
           [7,8,9]
         ]
Output:
matrix = [1,2,3,6,9,8,7,4,5]


Example 2:




Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
* */
