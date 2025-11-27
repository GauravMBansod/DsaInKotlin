package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode

fun main(){
    val bst = BinaryTree()
    //val array = arrayOf(1,2,3)//
    val array = arrayOf(-10,9,20,-1,-1,15,7)
     bst.buildTree(array)
    val maxPath = maximumPathSum(bst.rootNode)
    bst.preorderTraversal(bst.rootNode)
    println("maxPath: $maxPath")
}
var max = Int.MIN_VALUE

fun maximumPathSum(root : BinaryTreeNode?) :Int {
    if (root == null) return 0
    val left = maximumPathSum(root.left)
    val right = maximumPathSum(root.right)
    max = maxOf(max, left+right+root.value)
    return maxOf(0,left,right)+root.value // take path left or right which contribute to max positive value
    //in case of negative value return 0
} // TC: O(n), SC: O(n)
