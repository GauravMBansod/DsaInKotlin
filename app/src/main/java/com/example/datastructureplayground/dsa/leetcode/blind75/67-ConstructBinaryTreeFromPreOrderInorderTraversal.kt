package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode

fun main(){
val bst = BinaryTree()
    bst.rootNode = buildTree(intArrayOf(3,9,20,15,7),intArrayOf(9,3,15,20,7))
    bst.preorderTraversal(bst.rootNode)
}

var preOrderIndex : Int = 0
val inOrderMap = HashMap<Int,Int>()

fun buildTree(preOrder: IntArray, inOrder: IntArray): BinaryTreeNode? {

    for (i in inOrder){
        inOrderMap[i] = inOrder.indexOf(i)
    }

    return buildArrayToTree(preOrder,0,preOrder.size-1)

}

fun buildArrayToTree(preOrder: IntArray, left: Int, right: Int) : BinaryTreeNode? {
    if(left > right) return null

    val rootValue = preOrder[preOrderIndex++]
    val root = BinaryTreeNode(value = rootValue)

    root.left = buildArrayToTree(preOrder,left, inOrderMap[rootValue]?.minus(1) ?: right)
    root.right = buildArrayToTree(preOrder,inOrderMap[rootValue]?.plus(1) ?: left, right)

    return root

}// TC: O(n), SC: O(n)

/*

Practice - Construct Binary Tree from Preorder and Inorder Traversal
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

Output: [3,9,20,null,null,15,7]



Example 2:

Input: preorder = [-1], inorder = [-1]

Output: [-1]



Constraints:

preorder and inorder consist of unique values.

Each value of inorder also appears in preorder.

preorder is guaranteed to be the preorder traversal of the tree.

inorder is guaranteed to be the inorder traversal of the tree.

* */


