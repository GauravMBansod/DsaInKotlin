package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val combination = climbStairs(6)
    println("Combination: $combination")
    val combination2 = climbStairs2(6)
    println("Combination: $combination2")
}

fun climbStairs(n: Int): Int {

    if (n < 2) return n

    val intArrayCombination = IntArray(n+1)
    intArrayCombination[1] = 1
    intArrayCombination[2] = 2


    for (i in 3 .. intArrayCombination.size-1){
        intArrayCombination[i] = intArrayCombination[i-1] + intArrayCombination[i-2]
    }

    return intArrayCombination[n]
}
// TC: O(n), SC: O(1)

fun climbStairs2(n: Int): Int {

    if (n < 2) return n

    var first = 1
   var second = 2


    for (i in 3 .. n){
        val third = first + second
        first = second
        second = third
    }

    return second
}


/*
    Practice - Climbing Stairs
You are climbing a staircase. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2

Output: 2



Example 2:

Input: n = 3

Output: 3

Explanation:

1. 1 step + 1 step + 1 step

2. 1 step + 2 steps

3. 2 steps + 1 step


NB: Expected TC: O(n) and SC: O(1)


**/