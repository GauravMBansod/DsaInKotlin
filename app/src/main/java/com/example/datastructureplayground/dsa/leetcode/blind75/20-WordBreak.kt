package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val strArray = arrayOf("leet", "code")
    val str = "leetcode"
    val result = wordBreak(strArray, str)
    println("Result: $result")
}

fun wordBreak(strArray: Array<String> , str: String): Boolean {

    val dp = BooleanArray(str.length+1)
    val wordSet = strArray.toHashSet()


    //base case
    dp[0] = true

    for(i in 1..str.length){

        for (j in 0 .. i){
            val suffix = str.substring(j,i)
            if(dp[j] && wordSet.contains(suffix)){
                dp[i] = true
                break
            }
        }
    }
           return dp[str.length]

}// TC: O(n^3 + m), SC: O(n + m)

/*

* */



