package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList

fun main(){

    val list = SinglyLinkedList()

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(4)
    list.addLast(5)
    list.addLast(6)
    list.addLast(7)

    val mergedList = reorderList(list.head)

    list.head = mergedList
    list.printList()

    var a = 10
    val b = 12


}

fun reorderList(head: Node?) : Node?{

    var slow : Node? = head
    var fast : Node? = head

    while(fast?.nextNode?.nextNode != null || fast?.nextNode  != null){
        slow = slow?.nextNode
        fast = fast.nextNode?.nextNode
    }

    var secondHalf = slow?.nextNode
    slow?.nextNode = null

    secondHalf = reverseLinkedList(secondHalf)

    var firstHalf = head

    while(secondHalf != null){
        val next = firstHalf?.nextNode
        firstHalf?.nextNode = secondHalf
        firstHalf = next

        val next2 = secondHalf.nextNode
        secondHalf.nextNode = firstHalf
        secondHalf = next2
    }

    return head

}// TC: O(n), SC: O(1)

fun reverseLinkedList(head: Node?): Node? {
    var prev: Node? = null
    var current = head
    while (current != null) {
        val next = current.nextNode
        current.nextNode = prev
        prev = current
        current = next
    }
    return prev
    //return new head
}

/*
* Practice - Reorder List
You are given the head of a singly linked-list. The list is represented as:

L0 → L1 → … → Ln - 1 → Ln

Rearrange the list to the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You are not allowed to modify the values in the nodes. Only the nodes themselves can be changed.



Example 1:

Input: head = [1,2,3,4]

Output: [1,4,2,3]



Example 2:

Input: head = [1,2,3,4,5]

Output: [1,5,2,4,3]


Constraints:

The number of nodes in the list is in the range [1, 5 * 104].

1 <= Node.val <= 1000
* */