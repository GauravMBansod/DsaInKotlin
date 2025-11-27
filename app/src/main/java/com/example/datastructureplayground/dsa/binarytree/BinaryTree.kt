package com.example.datastructureplayground.dsa.binarytree

import java.util.LinkedList
import java.util.Queue


fun main(){
   // val arr = arrayOf(1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1)
    val arr = arrayOf(3,9,-1,-1,20,15,-1,-1,7,-1,-1)
    val binaryTree = BinaryTree()
    binaryTree.buildTree(arr)

    val subArr = arrayOf(20,7,-1,-1)
    val subBinaryTree = BinaryTree()
    subBinaryTree.buildTree(subArr)

    println("Tree 1:")
    println("preorderTraversal")
    binaryTree.preorderTraversal(binaryTree.rootNode)
    println()
    println("inorderTraversal")
    binaryTree.inorderTraversal(binaryTree.rootNode)
    println("")
    println("postorderTraversal")
    binaryTree.postorderTraversal(binaryTree.rootNode)
    println("")
    println("levelOrderTraversal")
    binaryTree.levelOrderTraversal(binaryTree.rootNode)

    println("countNodeHelper")
    println(binaryTree.countNode(binaryTree.rootNode))
    println("")
    println("countSumHelper")
    println(binaryTree.countSum(binaryTree.rootNode))

    println("heightOfTreeHelper")
    println(binaryTree.heightOfTree(binaryTree.rootNode))

    println("diameterOfTreeHelper")
    println(binaryTree.diameterOfTree(binaryTree.rootNode))

    println("diameter2Helper")
    println(binaryTree.diameter2(binaryTree.rootNode).diameter)

    println("\nTree 2 (Subtree):")
    println("subtree preorderTraversal")
    subBinaryTree.preorderTraversal(subBinaryTree.rootNode)
    println("\n")
    println("isSubtreeHelper")
    println(binaryTree.isSubtree(binaryTree.rootNode, subBinaryTree.rootNode)) // Note: with corrected subArr, this will be false

    println("")
    println("sumOfKthLevel")
    val klevelSum = binaryTree.sumOfKthLevel(binaryTree.rootNode, 3)
    println("klevelSum: $klevelSum")



}

data class BinaryTreeNode(var left: BinaryTreeNode? = null, var right: BinaryTreeNode? = null, var value: Int){
    override fun toString(): String {
        return "[left = ${left.toString()} \n right = ${right.toString()} \n value = $value] \t"
    }
}



class BinaryTree () {
    var rootNode : BinaryTreeNode? = null

    fun buildTree(arr: Array<Int>) {
        val index = intArrayOf(-1) // Using an array to pass index by reference
        this.rootNode = createBinaryTree(arr, index)
    }

    // create binary tree from array preorder traversal
    private fun createBinaryTree(arr: Array<Int>, index: IntArray): BinaryTreeNode? {
        index[0]++

        if (arr.isEmpty() || index[0] >= arr.size) return null

        if(arr[index[0]] == -1) return null

        val node = BinaryTreeNode(value = arr[index[0]])
        node.left = createBinaryTree(arr, index)
        node.right = createBinaryTree(arr, index)

        return node
    }


    fun preorderTraversal(node: BinaryTreeNode?){

        if(node == null) return

        print("${node.value} ")
        preorderTraversal(node.left)
        preorderTraversal(node.right)
    }

    fun inorderTraversal(node: BinaryTreeNode?){
        if(node == null) return

        inorderTraversal(node.left)
        print("${node.value} ")
        inorderTraversal(node.right)
    }

    fun postorderTraversal(node: BinaryTreeNode?){
        if(node == null) return

        postorderTraversal(node.left)
        postorderTraversal(node.right)
        print("${node.value} ")
    }

    fun levelOrderTraversal(root : BinaryTreeNode?){
        if(root == null) return

        val queue : Queue<BinaryTreeNode?> = LinkedList<BinaryTreeNode?>()
        queue.add(root)
        queue.add(null)

        while(queue.isNotEmpty()){
            val node = queue.remove()
            if(node == null){
                println()
                if(queue.isNotEmpty()) queue.add(null)
            }else {
                print("${node.value} ")
                if(node.left != null) queue.add(node.left)
                if(node.right != null) queue.add(node.right)
            }
        }
    }


    fun countNode(node: BinaryTreeNode?): Int {

        if (node == null) return 0

        val leftCount = countNode(node.left)
        val rightCount = countNode(node.right)

        return leftCount + rightCount + 1

    }

    fun countSum(node: BinaryTreeNode?): Int {

        if (node == null) return 0

        val leftSum = countSum(node.left)
        val rightSum = countSum(node.right)

        return leftSum + rightSum + node.value

    }

    fun heightOfTree(node: BinaryTreeNode?): Int {

        if(node == null) return 0

        val leftHeight = heightOfTree(node.left)
        val rightHeight = heightOfTree(node.right)

        return maxOf(leftHeight, rightHeight) + 1

    }

    fun diameterOfTree(node: BinaryTreeNode?): Int {
        if(node == null) return 0

        val leftDimeter = diameterOfTree(node.left)
        val rightDimeter = diameterOfTree(node.right)
        val diameterThroughRoot = heightOfTree(node.left) + heightOfTree(node.right) + 1

        return maxOf(leftDimeter, rightDimeter, diameterThroughRoot)
    } // TC : O(n2)

    data class TreeDiameterHeight(var diameter: Int ,var height: Int)

    fun diameter2(node: BinaryTreeNode?): TreeDiameterHeight {
        if (node == null) return TreeDiameterHeight(0,0)

        val left = diameter2(node.left)
        val right = diameter2(node.right)

        val myHeight = maxOf(left.height, right.height)+1
        val myDiameter = maxOf(myHeight, left.diameter, right.diameter)

        return TreeDiameterHeight(myDiameter, myHeight + 1)
    } // TC : O(n)


    /**
     * Checks if the binary tree starting at [subRoot] is a subtree of the one starting at [root].
     *
     * A subtree of a tree is a tree consisting of a node in the original tree and all of its descendants. [13]
     *
     * @param root The root node of the main binary tree.
     * @param subRoot The root node of the potential subtree.
     * @return `true` if [subRoot] is a subtree of [root], `false` otherwise.
     */
    fun isSubtree(root: BinaryTreeNode?, subRoot: BinaryTreeNode?): Boolean {
        // A null tree is always a subtree of any tree.
        // A non-null tree cannot be a subtree of a null tree.
        when {
            subRoot == null -> return true
            root == null -> return false
        }

        // Check if the tree starting at the current 'root' is identical to 'subRoot'.
        if (root.value == subRoot.value) {
            return isIdentical(root, subRoot)
        }

        // If not, recursively check if 'subRoot' is a subtree of the left or right child.
        // The '||' operator short-circuits, so the right side is only checked if the left is false. [6, 7, 8]
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    /**
     * Helper function to check if two trees are structurally and valuably identical.
     */

    fun isIdentical(node1: BinaryTreeNode?, node2: BinaryTreeNode?): Boolean {
        // Both nodes are null, so they are identical at this point.
        if (node1 == null && node2 == null) {
            return true
        }

        // One node is null but the other isn't, so they are not identical.
        if (node1 == null || node2 == null) {
            return false
        }

        // Check if values are the same and then recursively check children.
        return (node1.value == node2.value &&
                isIdentical(node1.left, node2.left) &&
                isIdentical(node1.right, node2.right))
    }

    fun sumOfKthLevel(root: BinaryTreeNode?, k: Int) {
        if (root == null) return

        val queue: Queue<BinaryTreeNode?> = LinkedList<BinaryTreeNode?>()
        queue.add(root)
        queue.add(null)
        var level = 1
        var sum = 0

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            if (node == null) {
                level++
                println()
                if (queue.isNotEmpty()) queue.add(null)
            } else {
                if(level == k){
                    sum+=node.value
                }
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }
        }
        println("Sum of Kth level is: $sum")
    }

    /*fun topViewOfTree(root: BinaryTreeNode?){
        if(root == null) return

        data class NodeWithHd(val node:BinaryTreeNode, val hd: Int)
        val queue: Queue<NodeWithHd> = LinkedList()
        val map = HashMap<Int, BinaryTreeNode>()

        var minHd = 0
        var maxHd = 0
        queue.add(NodeWithHd(root,0))

        while(queue.isNotEmpty()){
            val current = queue.remove()
            if(!map.containsKey(current.hd)){
                map[current.hd] = current.node
            }
            current.node.left?.let {
                queue.add(NodeWithHd(it, current.hd - 1))
                minHd = minOf(minHd, current.hd -1)
            }
            current.node.right?.let {
                queue.add(NodeWithHd(it, current.hd + 1))
                maxHd = maxOf(maxHd, current.hd+1)
            }
        }
        for(i in minHd..maxHd) print("${map[i]?.value} ")
    }*/

}