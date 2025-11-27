package com.example.datastructureplayground.dsa.linkedlist



public data class Node(var data: Int, var nextNode:Node? = null)

public class SinglyLinkedList(){
    var head: Node? = null

    fun addFirst(data : Int){
        val newNode = Node(data)
        if(head== null){
            head = newNode
        }
        else{
            newNode.nextNode = head
            head = newNode
        }
    }

    fun addLast(data: Int){
        val newNode = Node(data)
        if(head == null){
            head = newNode
        }
        else{
            var current = head
            while (current?.nextNode != null) {
                current = current.nextNode
            }
            current?.nextNode = newNode
        }

    }

    fun deleteFirst(){
        if(head == null) return
        head = head?.nextNode
    }

    fun deleteLast(){
        var current = head
        if(current?.nextNode == null){
            head = null
            return
        }
        while(current?.nextNode?.nextNode != null){
            current = current.nextNode
        }
        current?.nextNode = null
    }

    // Assuming your Node class looks something like this:
    // data class Node(var data: Int, var nextNode: Node? = null)
    // And 'head' is a mutable property of your LinkedList class:
    // var head: Node? = null

    fun delete(data: Int): Boolean {
        if (head == null) {
            return false // List is empty, nothing to delete
        }

        // Case 1: Delete head node
        if (head?.data == data) {
            head = head?.nextNode
            return true
        }

        // Case 2: Delete a node other than the head
        var current = head?.nextNode
        var previous = head

        while (current != null) {
            if (current.data == data) {
                previous?.nextNode = current.nextNode
                return true // Element found and deleted
            }

            //update pointers
            previous = current
            current = current.nextNode
        }

        return false // Element not found
    }

    fun printList(node : Node? = head){
        println()
        var current = node
        while (current != null){
            print("${current.data} ${if(current == head) "Head ->" else "->"}")
            current = current.nextNode
        }
    }

    fun reverseLinkedListIterative(head : Node?) : Node?{

        if(head == null || head.nextNode == null){
            return head
        }
        var prev: Node? = null
        var current = head

        while(current != null){
            val next = current.nextNode
            current.nextNode = prev

            //update pointers
            prev = current
            current = next
        }

        println()
        printList()
        //return new head
        return prev
    }

    fun reverseLinkedListRecursively(node : Node?): Node?{
         //base case
        if(node == null || node.nextNode == null){
            return node
        }

        val newHead = reverseLinkedListRecursively(node.nextNode)

        // node last node
        node.nextNode?.nextNode = node
        node.nextNode = null

        return newHead

    }

    //remove the nth node from the last
    fun removeTheNthNodeFromLast(head : Node?,n : Int){
        //find the size of the liked list
        var size = 0
        var currentNode = head
        while (currentNode != null){
            currentNode = currentNode.nextNode
            size++
        }

        if(size == n){
            this.head = head?.nextNode
        }

        val index = (size-n) // 9-3+1 = 7

        var prev = head
        var count = 1
        while (count < index){
            prev = prev?.nextNode
            print(prev?.data)
            count++
        }
        prev?.nextNode = prev.nextNode?.nextNode
    }

    //find palindrome

    fun findPalindrome(): Boolean {
        //find middle node
        val middleNode = findMiddleNode(head)

        var secondHalfStart = reverseLinkedListIterative(middleNode)
        var firstHalfStart = head

       while (secondHalfStart != null){
           if (secondHalfStart.data != firstHalfStart?.data){
               return false
           }
           secondHalfStart = secondHalfStart.nextNode
           firstHalfStart = firstHalfStart.nextNode
       }
        return true
    }

    private fun findMiddleNode(head : Node?) : Node? {
        var fast = head
        var slow = head

        while (fast != null && fast.nextNode != null){
            slow = slow?.nextNode
            fast = fast.nextNode?.nextNode
        }
        return slow

    }

}

fun main(){
    val list = SinglyLinkedList()
    /*for(i in 1..9) {
        list.addLast(i)
    }*/

    list.addLast(1)
    list.addLast(2)
    list.addLast(3)
    list.addLast(1)
   // list.reverseLinkedListIterative()
   // list.head = list.reverseLinkedListRecursively(list.head)
   // list.printList()
   // list.removeTheNthNodeFromLast(list.head,9)
    list.printList()
    val isPalindrome = list.findPalindrome()

    println("palindrome $isPalindrome")

}