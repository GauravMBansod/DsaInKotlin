package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode
import java.util.LinkedList

fun main(){
val bst = BinaryTree()
    bst.buildTree(arrayOf(5,4,3,-1,-1,-1,6,-1,-1))
    bst.inorderTraversal(bst.rootNode)
    println()
    bst.levelOrderTraversal(bst.rootNode)
    println("is valid BST : ${isValidBinaryTree(bst.rootNode)}")
}

fun isValidBinaryTree(root: BinaryTreeNode?): Boolean{
    val isBst = true
    val list = LinkedList<Int>()
    inOrderTraversal( list, root = root )

    var prev = list[0]
    for (i in 1..list.size-1){
        if(prev >= list[i]){
            return false
        }
        prev = list[i]
    }
    return isBst
}

fun inOrderTraversal(list: LinkedList<Int>, root: BinaryTreeNode?): BinaryTreeNode? {

    if (root == null) return null
    inOrderTraversal(list,root.left)
    list.add(root.value)
    inOrderTraversal(list, root.right)

    return root
}

/*
Practice - Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).



Example 1:

Input: root = [2,1,3]

Output: true



Example 2:

Input: root = [5,1,4,null,null,3,6]

Output: false

Explanation: The root node's value is 5 but its right child's value is 4.



Constraints:

The number of nodes in the tree is in the range [1, 104].

-2^31 <= Node.val <= 2^31 - 1
* */