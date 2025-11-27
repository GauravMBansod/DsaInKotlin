package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node

fun main(){

}
// https://www.youtube.com/watch?v=6gI8OMoac4Q

fun removeNThNodeFromTheEndOFList(head : Node?, n : Int) : Node?{
    var dummy = Node(-1)
    dummy.nextNode = head

    var fast = dummy
    var slow = dummy

    for (n in 1..n){
        fast = fast.nextNode!!
    }

    while (fast.nextNode != null){

        fast = fast.nextNode!!
        slow = slow.nextNode!!

    }
    // delete actual node here
    slow.nextNode = slow.nextNode?.nextNode

    return dummy.nextNode
} // TC: O(n), SC: O(n)

/*Practice - Remove Nth Node From End Of List
Given a linked list, remove the n-th node from the end of list and return its head.



Example 1:

Input: list= 1->2->3->4->5, and n = 2.

Output: list = 1->2->3->5.



NB: Given n will always be valid.
*/
