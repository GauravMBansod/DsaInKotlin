package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList

fun main() {
val l1 = SinglyLinkedList()
    l1.addLast(1)
    l1.addLast(2)
    l1.addLast(4)

val l2 = SinglyLinkedList()
    l2.addLast(1)
    l2.addLast(3)
    l2.addLast(7)

val mergedList = mergeTwoSortedList(l1.head,l2.head)
    l2.head = mergedList
    l2.printList()
}

fun mergeTwoSortedList(l1 : Node?, l2 : Node?) : Node? {
    var curr : Node? = Node(-1)
    val newHead = curr
    var p1 = l1
    var p2 = l2

    while (p1 != null && p2 != null){
        if(p1.data < p2.data){
            curr?.nextNode = p1
            curr = curr?.nextNode
            p1 = p1.nextNode
        }else{
            curr?.nextNode = p2
            curr = curr?.nextNode
            p2 = p2.nextNode
        }
    }

   if(p1 != null){
       curr?.nextNode = p1
   }
   if(p2 != null){
       curr?.nextNode = p2
   }
    return newHead?.nextNode
}// TC: O(m + n), SC: O(1)

/*Practice - Merge Two Sorted Lists
You are given the heads of two sorted linked lists, list1 and list2.

Merge the two lists into one sorted list by splicing together the nodes of the two lists.

Return the head of the merged linked list.



Example 1:

Given:

list1: 1 -> 2 -> 4

list2: 1 -> 3 -> 4

Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4

Explanation: The merged list is sorted in non-decreasing order.



Example 2:

Given:

list1: (empty list)

list2: (empty list)

Output: (empty list)

Explanation: Both lists are empty, so the merged list is also empty.



Example 3:

Given:

list1: (empty list)

list2: 0

Output: 0

Explanation: The merged list contains the single node with value 0.



Constraints:

The number of nodes in both lists is in the range [0, 50].

Each node's value is in the range [-100, 100].

Both list1 and list2 are sorted in non-decreasing order.*/

