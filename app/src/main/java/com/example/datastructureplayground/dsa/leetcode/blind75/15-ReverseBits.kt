package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val reverseNumber = reverseBits(43261596)
    println("Reverse Number: $reverseNumber")
}

fun reverseBits(n: Int): Int {
    var reversedBits = 0
    var numToProcess = n
    for (i in 0 until 32) {
        reversedBits = reversedBits shl 1
        if ((numToProcess and 1) == 1) {
            reversedBits = reversedBits or 1
        }
        numToProcess = numToProcess shr 1
    }
    return reversedBits
} // tc O(1), sc O(1)

/*
Practice - Reverse Bits
Reverse the bits of a given 32-bit unsigned integer. Input and output are signed integers. Input is a 32-bit binary string.



Example 1:

Input:  43261596  (00000010100101000001111010011100)

Output: 964176192 (00111001011110000010100101000000)



Example 2:

Input: 11111111111111111111111111111101

Output: 3221225471 (10111111111111111111111111111111)



*/