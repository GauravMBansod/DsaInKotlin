package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val maxRobbery = robHouse2(intArrayOf(2,7,9,3,1))
    println("Max Robbery: $maxRobbery")
}

fun robHouse2(houses: IntArray): Int{
    val robbery1 = robHouseHelper(houses.copyOfRange(0, houses.size-1))
    val robbery2 = robHouseHelper(houses.copyOfRange(1, houses.size))
    return Math.max(robbery1, robbery2)
}

fun robHouseHelper(houses: IntArray): Int{

    if(houses.isEmpty()) return 0
    if(houses.size == 1) return houses[0]
    if(houses.size == 2) return Math.max(houses[0], houses[1])

    var prev1 = houses[0]
    var prev2 = Math.max(houses[0], houses[1])

    for(i in 2 until houses.size){
        houses[i] = Math.max(prev1 + houses[i], prev2)
        prev1 = prev2
        prev2 = houses[i]
    }

    return houses[houses.size-1]
} // TC: O(2n), SC: O(1)



