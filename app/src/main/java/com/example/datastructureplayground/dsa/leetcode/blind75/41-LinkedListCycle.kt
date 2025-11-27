package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList

fun main(){
    val list = SinglyLinkedList()

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(4)
    list.addLast(2)

    list.head?.nextNode?.nextNode?.nextNode?.nextNode = list.head?.nextNode?.nextNode

    val hasCycle = linkedListCycle(list.head)
    println("Has Cycle: $hasCycle")

}

fun linkedListCycle(head: Node?): Boolean {

    if(head == null || head.nextNode == null){
        return false
    }

    var slow = head
    var fast = head

    while(fast != null && fast.nextNode != null){
        slow = slow?.nextNode
        fast = fast.nextNode?.nextNode

        if(slow == fast){
            return true
        }
    }
    return false
}

/*
* Practice - Detect Cycle in a Linked List
Given the head of a linked list, check if the list has a cycle.

A cycle exists if a node can be reached again by following the next pointers.

Return true if there is a cycle, false otherwise.



Example 1:



Input: head =
3 -> 2 -> 0 -> -4 -> 2
      ^         |
      |---------|

Output: true
Explanation: There is a cycle in the list.


Example 2:



Input: head =
1 -> 2
^    |
|    |
------

Output: true
Explanation: There is a cycle in the list.


Example 3:



Input: head = 1
Output: false
Explanation: No cycle in the list.


Constraints:

The number of nodes in the list is between 0 and 10^4.

Each node's value is between -10^5 and 10^5.

Follow-up: Can you solve this with O(1) (constant) memory?

*/