package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode
import java.util.LinkedList
import java.util.Queue

fun main(){

    val tree = BinaryTree()
     tree.buildTree(arrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1))
    val result = levelOrderTraversal(tree.rootNode)

    for(i in result) {
        println()
       for(j in i) print("$j ")
    }
    println()
}

fun levelOrderTraversal(root : BinaryTreeNode?) : ArrayList<ArrayList<Int>>{
    val result = ArrayList<ArrayList<Int>>()
    if(root == null) return result

    val queue : Queue<BinaryTreeNode> = LinkedList()
    queue.add(root)

    while(queue.isNotEmpty()){
        var levelSize = queue.size
        val currentLevel = ArrayList<Int>()

        while(levelSize > 0) {

            val currentNode = queue.poll()
            if (currentNode != null) {
                currentLevel.add(currentNode.value)
            }

            if(currentNode?.left != null) {
                queue.add(currentNode.left)
            }

            if(currentNode?.right != null) {
                queue.add(currentNode.right)
            }

        levelSize--
        }
        result.add(currentLevel)
    }

    return result
} // TC: O(n), SC: O(n)

/*

Practice - Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:


Input: root = [3,9,20,null,null,15,7]

Output: [[3],[9,20],[15,7]]



Example 2:

Input: root = [1]

Output: [[1]]



Example 3:

Input: root = []

Output: []




Constraints:

The number of nodes in the tree is in the range [0, 2000].

-1000 <= Node.val <= 1000

* */