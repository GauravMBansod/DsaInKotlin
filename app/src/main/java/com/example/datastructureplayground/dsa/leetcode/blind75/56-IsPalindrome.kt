package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val isPalindrome = isValidPalindrome("A man, a plan, a canal: Panama")
    println(isPalindrome)
}

fun isValidPalindrome(str : String) : Boolean{
    var p1 = 0
    var p2 = str.length-1

    while(p1 < p2){

        if(!str[p1].isLetterOrDigit()) p1++
        if(!str[p2].isLetterOrDigit()) p2--

        if(str[p1].lowercase() != str[p2].lowercase()){
            return false
        }
        p1++
        p2--

    }

    return true
}