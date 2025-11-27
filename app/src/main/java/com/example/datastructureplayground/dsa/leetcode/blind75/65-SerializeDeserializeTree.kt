package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinaryTree
import com.example.datastructureplayground.dsa.binarytree.BinaryTreeNode
import java.util.LinkedList
import java.util.Queue

fun main(){
    val bst = BinaryTree()
  val root = BinaryTreeNode(value = 1)
  root.left = BinaryTreeNode(value = 2)
  root.right = BinaryTreeNode(value = 3)
    root.left?.left = BinaryTreeNode(value = 4)
    root.left?.right = BinaryTreeNode(value = 5)

    bst.rootNode = root

    bst.levelOrderTraversal(bst.rootNode)

    val serialized = serialize(root)
    println(serialized)
    val deserialized = deserialize(serialized)

    bst.levelOrderTraversal(deserialized)

}

fun serialize(root: BinaryTreeNode?): String? {

    if(root == null) return null
    val left = serialize(root.left)
    val right = serialize(root.right)
    return root.value.toString() + "," + left + "," + right
}

fun deserialize(data: String?) : BinaryTreeNode? {
    if(data == null) return null
    val queue : Queue<String> = LinkedList(data.split(","))
    return deserializeHelper(queue)
}

fun deserializeHelper(queue: Queue<String>) : BinaryTreeNode? {
    val current = queue.poll()

    if(current == "null") return null
    val root = BinaryTreeNode(value = current.toInt())

    root.left = deserializeHelper(queue)
    root.right = deserializeHelper(queue)

    return root

}

/*
*
Practice - Serialize and Deserialize Binary Tree
You need to create a method to convert a binary tree into a string and another method to reconstruct the tree from that string.

Serialize:

Convert a binary tree to a string.

Output should allow rebuilding the tree.

Deserialize:

Rebuild the original binary tree from the string.

Example:

Input: [1,2,3,null,null,4,5]

Output: [1,2,3,null,null,4,5]

Constraints:

Nodes range: [0, 10^4]

Node values: -1000 <= Node.val <= 1000
* */