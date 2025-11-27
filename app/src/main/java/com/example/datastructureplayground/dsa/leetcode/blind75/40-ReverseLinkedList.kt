package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList

fun main(){
    val list = SinglyLinkedList()
    for(i in 1..9) {
        list.addLast(i)
    }
    list.printList()
    list.head = reverseLinkedListRecursively(list.head)
    list.printList()
}

fun reverseLinkedListIterative(head : Node?) : Node? {


    if(head == null || head.nextNode == null){
        return head
    }

    var prev : Node? = null
    var current = head
    while (current != null){
        var next  = current.nextNode
        current.nextNode = prev

        //update pointers
        prev = current
        current = next
    }

    return prev

}

fun reverseLinkedListRecursively(head : Node?) : Node?{
    if(head == null || head.nextNode == null){
        return head
    }

    val newHead = reverseLinkedListRecursively(head.nextNode)
    head.nextNode?.nextNode = head
    head.nextNode = null
    return newHead
}//SC : O(n) , TC: O(n)











