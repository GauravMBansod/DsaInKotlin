package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val matrix = arrayOf(intArrayOf(1,1,1), intArrayOf(1,0,1), intArrayOf(1,1,1))
    printMatrix(matrix)
    setZeroMatrix(matrix)
    println()
    printMatrix(matrix)
}

fun printMatrix(matrix: Array<IntArray>) {
    for (i in 0 until matrix.size){
        for (j in 0 until matrix[0].size){
            print("${matrix[i][j]} ")
        }
        println()
    }
}

fun setZeroMatrix(matrix: Array<IntArray>) {

    var hasFirstRow = false
    var hasFirstColumn = false

    for (r in 0 until matrix.size){
        if(matrix[r][0] == 0){
            hasFirstColumn = true
            break
        }
    }

    for (c in 0 until matrix[0].size){
        if(matrix[0][c] == 0){
         hasFirstRow = true
            break
        }
    }
    //preprocessing
    for (i in 1 until matrix.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] == 0){
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }

    for (row in 1 until matrix.size) {
        if(matrix[row][0] == 0) nullifyRow(matrix, row)
    }

    for (col in 1 until matrix[0].size) {
        if(matrix[0][col] == 0) nullifyColumn(matrix, col)
    }

    if(hasFirstRow) nullifyRow(matrix, 0)
    if(hasFirstColumn) nullifyColumn(matrix, 0)

}

fun nullifyRow(matrix: Array<IntArray>, row: Int) {
    for (c in 0 until matrix[0].size){
        matrix[row][c] = 0
    }
}

fun nullifyColumn(matrix: Array<IntArray>, col: Int) {
    for (r in 0 until matrix.size){
        matrix[r][col] = 0
    }
}// TC: O(R) + O(C) + O(R * C) + O(R * C), SC: O(1)
