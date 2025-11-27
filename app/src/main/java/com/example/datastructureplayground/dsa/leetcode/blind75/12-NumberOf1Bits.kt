package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val count = numberOf1Bits(11)
    println("Count: $count")
    println("Count: ${11.countOneBits()}.")
}

fun numberOf1Bits(number: Int) : Int{
    var count = 0

    for(i in 0..31){
        val mask = 1 shl i
        if((number and mask) != 0){
            count++
        }
    }

    return count
}// TC: O(1), SC: O(1)

/*
*Practice - Number of 1 Bits
Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has


Example 1:

Input: n = 00000000000000000000000000001011

Output: 3

Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.



Example 2:

Input: n = 00000000000000000000000010000000

Output: 1



Example 3:

Input: n = 11111111111111111111111111111101

Output: 31


Constraints:

The input must be a binary string of length 32.




Follow up: If this function is called many times, how would you optimize it?
* */