package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList
import java.util.PriorityQueue

fun main(){
    val list1 = SinglyLinkedList()
    list1.addLast(1)
    list1.addLast(2)
    list1.addLast(5)

    val list2 = SinglyLinkedList()
    list2.addLast(1)
    list2.addLast(4)
    list2.addLast(33)

    val list3 = SinglyLinkedList()
    list3.addLast(2)
    list3.addLast(6)


    val arr = arrayOf(list1.head, list2.head, list3.head)
    val mergedList = SinglyLinkedList()

    val head = mergeKList(arr)
    mergedList.head = head
    mergedList.printList(head)
}

fun mergeKList(lists: Array<Node?>): Node? {
    val pq = PriorityQueue<Node?>(Comparator { a, b -> a.data - b.data })

    for (head in lists) {
        if (head != null) {
            pq.add(head)
        }
    }

    val dummyHead = Node(-1)
    var curr = dummyHead
    while (pq.isNotEmpty()) {
        val minNode = pq.poll()
        curr.nextNode = minNode
        curr = curr.nextNode!!

        if (minNode?.nextNode != null) {
            pq.add(minNode.nextNode)
        }
    }
    return dummyHead.nextNode
}
