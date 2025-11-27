package com.example.datastructureplayground.dsa.leetcode.blind75
fun main(){
    val sum = sumOfTwoIntegers(-6,2)
    println("Sum: $sum")
}

fun sumOfTwoIntegers(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        val carry = a and b
        a = a xor b
        b = carry shl 1
    }
    return a
}// TC: O(1), SC: O(1)
/*
*
* Practice - Sum of Two Integers
Given two integers a and b, return the sum of the two integers without using arithmetic operators.



Example 1:

Input: a = 1, b = 2

Output: 3



Example 2:

Input: a = -2, b = -3

Output: -5



Example 3:

Input: a = 2, b = 3

Output: 5



Constraints:

-1000 <= a, b <= 1000

*/