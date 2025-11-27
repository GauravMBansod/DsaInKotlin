package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode

fun main(){
    val arr = arrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1)
    val binaryTree = BinaryTree()
    binaryTree.buildTree(arr)
    binaryTree.preorderTraversal(binaryTree.rootNode)
    println()
    val subArr = arrayOf(3,-1,6,-1,-1) // Changed 7 to 6 to match a subtree in the main tree
    val subBinaryTree = BinaryTree()
    subBinaryTree.buildTree(subArr)
    subBinaryTree.preorderTraversal(subBinaryTree.rootNode)
    println()
    println("isSubTree :- ${isSubTree(binaryTree.rootNode, subBinaryTree.rootNode)}")

}

fun isSubTree(root : BinaryTreeNode?, subRoot : BinaryTreeNode?) : Boolean{
    if (subRoot == null) return true
    if (root == null) return false

    if (root.value == subRoot.value && isIdentical(root,subRoot)){
        return true
    }

    val left = isSubTree(root.left,subRoot)
    val right = isSubTree(root.right, subRoot)

    return left || right
}

fun isIdentical(root : BinaryTreeNode?, subRoot : BinaryTreeNode?) : Boolean{
    if(root == null && subRoot == null) return true
    if (root == null || subRoot == null) return false
    if (root.value != subRoot.value) return false

    val left = isIdentical(root.left,subRoot.left)
    val right = isIdentical(root.right, subRoot.right)

    return left && right
}

/*

Practice - Subtree of Another Tree

You're asked to determine if there exists a subtree within the root binary tree that has the exact structure and node values as the subRoot binary tree.

A subtree in a binary tree is defined as a tree that includes a node from the root tree and all of its descendants. This includes the root tree itself.

Return true if such a subtree exists, and false otherwise. Example 1:

 Input: root = [3,4,5,1,2], subRoot = [4,1,2] Output: true
Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]

Output: false

* */