
package com.example.datastructureplayground.dsa.leetcode.blind75

import java.util.Stack

fun main(){
    val str = "{()}[]"
    val isValid = isValidParenthesis(str)
    println(isValid)
}

fun isValidParenthesis(str : String) : Boolean{
    val stack = ArrayDeque<Char>()
    val map = HashMap<Char, Char>()
    map['}'] = '{'
    map[']'] = '['
    map[')'] = '('

    for (char in str){

       //check closing in hashmap
       if(map.containsKey(char)){


           if( stack.isEmpty() || stack.removeLastOrNull() != map[char]) {
               return false
           }

       }else{
           //add opening bracket to stack
           stack.addLast(char)
       }
    }

    return stack.isEmpty()
}// TC: O(n), SC: O(n)

/*
Practice - Valid Parenthesess
Given a string s containing only the characters '(', ')', '{', '}', '[', and ']', determine if it is a valid string.

A string is considered valid if it meets the following conditions:

Open brackets ('(', '{', '[') must be closed by the same type of brackets.

Open brackets must be closed in the correct order.

Every closing bracket has a corresponding open bracket of the same type.

Examples:

Input: s = "()"

Output: true

Explanation: The string contains a valid pair of parentheses.

Input: s = "()[]{}"

Output: true

Explanation: The string contains valid pairs of parentheses, square brackets, and curly braces.

Input: s = "(]"

Output: false

Explanation: The string contains an invalid pair of parentheses, '(' is not properly closed.

Constraints:

1 <= s.length <= 10^4

The string s consists only of the characters '(', ')', '{', '}', '[', and ']'.*/