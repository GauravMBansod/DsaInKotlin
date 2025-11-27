package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val matrix = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9))
    printMatrix(matrix)
    rotateImage(matrix)
    println()
    printMatrix(matrix)

}

fun rotateImage(matrix : Array<IntArray>){
    // Transpose the matrix
    for (i in matrix.indices){
        for (j in i until matrix.size){
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    // Reverse each row
    for (i in matrix.indices){
        var l = 0
        var r = matrix.size-1
        while (l < r){
            val temp = matrix[i][l]
            matrix[i][l] = matrix[i][r]
            matrix[i][r] = temp
            l++;r--
        }
    }
}

/*
Practice - Rotate Image
You are given an n x n 2D matrix(square) representing an image, rotate the image by 90 degrees (clockwise).



You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:




Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]

Output: [[7,4,1],[8,5,2],[9,6,3]]



Example 2:




Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


*/