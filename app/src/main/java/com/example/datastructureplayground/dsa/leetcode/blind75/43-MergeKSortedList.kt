package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.linkedlist.Node
import com.example.datastructureplayground.dsa.linkedlist.SinglyLinkedList

fun main(){
    val l1 = SinglyLinkedList()
    l1.addLast(1)
    l1.addLast(6)
    l1.addLast(8)

    val l2 = SinglyLinkedList()
    l2.addLast(1)
    l2.addLast(3)
    l2.addLast(5)

    val l3 = SinglyLinkedList()
    l3.addLast(1)
    l2.addLast(6)
    l2.addLast(10)

    val arrayList = arrayListOf<Node?>( l1.head,l2.head,l3.head)

    l1.head = (mereKSortedList(arrayList) ?: Node(-1))
    l1.printList()

}

fun mereKSortedList(arrayList: ArrayList<Node?>) : Node?{

    val k = arrayList.size

    for(i in 1 until k){
        arrayList[0] = merge2SortedList(arrayList[0],arrayList[i])
    }

    return arrayList[0]
}// TC: O(n * log k) , SC: O(1)

fun merge2SortedList(l1 : Node?, l2 : Node?) : Node?{

    val newHead : Node? = Node(-1)
    var curr = newHead
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

    if(p1 == null) curr?.nextNode = p2
    if(p2 == null) curr?.nextNode = p1

    return newHead?.nextNode


}

/*Practice - Merge K Sorted Lists
Merge k sorted linked lists into one sorted linked list.



Example:



Input: [
    1 -> 4 -> 5,
    1 -> 3 -> 4,
    2 -> 6
]
Output: [1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6]
*/