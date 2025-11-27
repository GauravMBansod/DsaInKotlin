package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode

fun main(){
    val tree = BinaryTree()
    tree.buildTree(arrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1))

    println("Original tree preorder traversal:")
    tree.levelOrderTraversal( tree.rootNode)
    println()

    // The invertTree function modifies the tree in-place.
    // After this call, tree.rootNode points to the root of the now inverted tree.
    invertTree(tree.rootNode)
    println("Inverted tree preorder traversal:")
    tree.levelOrderTraversal(tree.rootNode)

}

fun invertTree(root : BinaryTreeNode?) : BinaryTreeNode?{

    if(root == null) return null

    val left = invertTree(root.left)
    val right = invertTree(root.right)

    root.left = right
    root.right = left

    return root
}// TC: O(n), SC: O(n)

/*
*
* Practice - Invert/Flip Binary Tree
Given the root of a binary tree, invert the tree, and return its root.


Example 1:






Input: root = [4,2,7,1,3,6,9]

Output: [4,7,2,9,6,3,1]



Example 2:



Input: root = [2,1,3]

Output: [2,3,1]



Example 3:



Input: root = []

Output: []




Constraints:

The number of nodes in the tree is in the range [0, 100].

-100 <= Node.val <= 100
* */