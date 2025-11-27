package com.example.datastructureplayground.dsa.leetcode.general


import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList

fun main(args: Array<String>) {
    val linkedList = SinglyLinkedList()

    for(i in 1..10) {
        linkedList.addLast(i)
    }

    linkedList.printList()
    println()

   val newHead = reverseBetween(linkedList.head, 2, 4)
    println(newHead)
    linkedList.printList()
}

fun reverseBetween(head: Node?, left: Int, right: Int): Node? {
    // Edge case: single node or no reversal needed
    if (head?.nextNode == null || left == right) {
        return head
    }


    // Create dummy node to simplify edge cases when left = 1
    val dummy: Node = Node(0, head)


    // Find the node just before the reversal section
    var beforeReverse: Node = dummy
    for (i in 0..<left - 1) {
        beforeReverse = beforeReverse.nextNode!!
    }


    // Save important connection points
    val connectionBeforeReverse: Node? = beforeReverse // Node before the reversed section
    val firstNodeToReverse: Node? =
        beforeReverse.nextNode // First node in the section to be reversed


    // Reverse the sublist from position left to right
    var previous: Node? = beforeReverse  //1
    var current: Node? = firstNodeToReverse //2

    for (i in 0..right - left + 1) { //
        // Standard linked list reversal: save nextNode, point back, move forward
        val nextNode: Node? = current?.nextNode
        current?.nextNode = previous
        previous = current
        current = nextNode
    }


    // Reconnect the reversed section with the rest of the list
    connectionBeforeReverse?.nextNode = previous // Connect to the new head of reversed section previous = 4
    firstNodeToReverse?.nextNode = current // Connect the tail of reversed section to remaining list current 5

    return dummy.nextNode
}