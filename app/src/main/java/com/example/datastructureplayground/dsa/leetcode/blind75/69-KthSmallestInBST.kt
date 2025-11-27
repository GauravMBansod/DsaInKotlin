package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinarySearchTree
import com.example.datastructureplayground.dsa.binarytree.BinarySearchTreeNode

fun main(){
    val bst = BinarySearchTree()
    for(i in 1..20 step 2){
        bst.root = bst.insert(bst.root,i)
    }
    println()
    val k = 6
    val value = kThSmallestInBst2(bst.root,6)
    println("$k th smallest is $value")

}

fun kThSmallestInBst(root : BinarySearchTreeNode?, k : Int): Int {
    if(root == null) return -1
    val list = ArrayList<Int>()
    inorderTraverse(list, root)
    println(list)

    if (k > 0 && k <= list.size) {
        return list[k - 1]
    }
    return -1
}

fun inorderTraverse(list: ArrayList<Int>, root: BinarySearchTreeNode?): BinarySearchTreeNode? {
    if(root == null) return null

    root.left = inorderTraverse(list,root.left)
    list.add(root.value)
    root.right = inorderTraverse(list, root.right)

    return root

}

fun kThSmallestInBst2(root: BinarySearchTreeNode?, k: Int): Int? {
    // Validate k to ensure it's a positive number.
    if (k <= 0) return null

    val stack = ArrayDeque<BinarySearchTreeNode>()
    var currentNode = root
    var count = 0

    while (currentNode != null || stack.isNotEmpty()) {
        // Traverse to the leftmost node of the current subtree.
        while (currentNode != null) {
            stack.addLast(currentNode)
            currentNode = currentNode.left
        }

        // Pop the last-visited node (which is the next in in-order sequence).
        val node = stack.removeLast()
        count++

        // If we have found the k-th element, return its value.
        if (count == k) {
            return node.value
        }

        // Move to the right subtree to continue the in-order traversal.
        currentNode = node.right
    }

    // Return null if k is greater than the number of nodes in the tree.
    return null
}

/*
Practice - Kth Smallest Element in a BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.



Example 1:

Input: root = [3,1,4,null,2], k = 1

Output: 1



Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3

Output: 3


Constraints:

The number of nodes in the tree is n.

1 <= k <= n <= 104

0 <= Node.val <= 104



Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
and you need to find the kth smallest frequently, how would you optimize?

* */