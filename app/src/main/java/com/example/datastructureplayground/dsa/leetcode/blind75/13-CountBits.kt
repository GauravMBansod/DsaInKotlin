package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val count = countBits(2)
    print("[")
    for(i in count) {
        print("$i ")
    }
    print("]")
}

fun countBits(n: Int): IntArray {
    val result : IntArray = IntArray(n+1)
    for(i in 0..n){
        result[i] = result[i shr 1] + (i and 1)
    }
    return result
}// TC: O(n), SC: O(n)

/*
* Practice - Counting Bits
Given an integer n, return an array ans of length n+1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i. Without using any builtin functions.



Example 1:

Input: n = 2

Output: [0,1,1]

Explanation:

0 --> 0

1 --> 1

2 --> 10



Example 2:

Input: n = 5

Output: [0,1,1,2,1,2]

Explanation:

0 --> 0

1 --> 1

2 --> 10

3 --> 11

4 --> 100

5 --> 101


Constraints:

0 <= n <= 105*/