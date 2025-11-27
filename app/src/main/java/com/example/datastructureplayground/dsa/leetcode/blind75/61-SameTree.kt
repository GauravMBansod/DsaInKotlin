package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode

fun main(){
    val tree1 = BinaryTree()
    tree1.buildTree(arrayOf(1,2,3))

    val tree2 = BinaryTree()
    tree2.buildTree(arrayOf(1,2,3))

    val isSame = isSameTree(tree1.rootNode, tree2.rootNode)
    println("same tree $isSame")

}

fun isSameTree(n1 : BinaryTreeNode?, n2 : BinaryTreeNode?): Boolean {

    if(n1 == null && n2 == null) return true
    if(n1 == null || n2 == null) return false

    if(n1.value != n2.value) return false

    val left = isSameTree(n1.left, n2.left)
    val right = isSameTree(n1.right, n2.right)

    return left && right

}// TC: O(n), SC: O(n)

/*Practice - Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not. Two binary trees are considered the same if they are structurally identical, and the nodes have the same value. Example 1:




Input: p = [1,2,3], q = [1,2,3]

Output: true



Example 2:

Input: p = [1,2], q = [1,null,2]

Output: false



Example 3:

Input: p = [1,2,1], q = [1,1,2]

Output: false




Constraints:

The number of nodes in both trees is in the range [0, 100].

-104 <= Node.val <= 104
*/