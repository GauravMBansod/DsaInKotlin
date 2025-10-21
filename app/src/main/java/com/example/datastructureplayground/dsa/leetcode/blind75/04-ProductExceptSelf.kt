package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
   val product = productExceptSelf(intArrayOf(1,2,3,4))
    for (num in product){
        println(num)
    }
}

fun productExceptSelf(intArray: IntArray): IntArray{
    val prefixProduct = IntArray(intArray.size)
    prefixProduct[0] = 1
    for (i in 1 until intArray.size){
        prefixProduct[i] += prefixProduct[i-1]
    }

    var suffixproduct = 1

    for (i in intArray.size-1 downTo 0){
        prefixProduct[i] *= suffixproduct
        suffixproduct *= intArray[i]

    }
    return prefixProduct

}// TC: O(n) SC: O(n)

/*
* */