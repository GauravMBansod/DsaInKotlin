package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode

fun main(){
    val tree = BinaryTree()
    val arr = arrayOf(3,9,20,-1,-1,15,7)
     tree.buildTree(arr)
    val maxDepth = maximumDepthOfBinaryTree(tree.rootNode)
    println("maxDepth $maxDepth")
}

fun maximumDepthOfBinaryTree(root : BinaryTreeNode?) : Int {

    if(root == null) return 0
    val leftDepth = maximumDepthOfBinaryTree(root.left)
    val rightDepth = maximumDepthOfBinaryTree(root.right)
    return maxOf(leftDepth, rightDepth) + 1

}// TC: O(n), SC: O(n)

/*Practice - Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



Example 1:


Input: root = [3,9,20,null,null,15,7]

Output: 3



Example 2:

Input: root = [1,null,2]

Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104]

-100 <= Node.val <= 100*/