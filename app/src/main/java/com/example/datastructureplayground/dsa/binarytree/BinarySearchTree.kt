package com.example.datastructureplayground.dsa.binarytree

import androidx.collection.MutableIntList


fun main(){
    val array = intArrayOf(8,5,3,6,10,11,14)
    val bst = BinarySearchTree()
    for(i in array) {
        bst.root = bst.insert(bst.root, i)
    }
    bst.inOrderTraversal(bst.root)
    val key = 10
    val isAvailable = bst.search(bst.root,key)
    println()
    println("$key is ${if(isAvailable) "available" else "not available" }")
    println()
   // bst.root = bst.delete(bst.root,10)
    bst.inOrderTraversal(bst.root)

    val x = 1
    val y = 5

    println()
    print("printInRange in range $x and $y = : ")
    bst.printInRange(1,5,bst.root)

    println()
    print("printRootTONode =: ")
    bst.printRootTONode(bst.root)
    //bst.printRootToLeafPaths(bst.root)
}

data class BinarySearchTreeNode(var left: BinarySearchTreeNode? = null, var right: BinarySearchTreeNode? = null, var value: Int)
class BinarySearchTree() {
    var root : BinarySearchTreeNode? = null

    fun insert(root: BinarySearchTreeNode?, value: Int): BinarySearchTreeNode? {

        if (root == null) {
            return BinarySearchTreeNode(value = value)
        }
        else if (root.value > value) {
            root.left = insert(root.left, value)
        } else if (root.value < value) {
            root.right = insert(root.right, value)
        }

        return root
    }

    fun inOrderTraversal(root: BinarySearchTreeNode?)  {
        if (root == null) return
        inOrderTraversal(root.left)
        print("${root.value} ")
        inOrderTraversal(root.right)

    }

    fun search(root : BinarySearchTreeNode?,key : Int): Boolean {
        if(root == null) return false
        if(root.value == key) return true
        if(root.value < key) return search(root.right , key)
        else return search(root.left , key)
    }

    fun delete(root : BinarySearchTreeNode?, key: Int) : BinarySearchTreeNode? {

        if (root == null) return null
        if (root.value > key) {
            root.left = delete(root.left, key)
        } else if (root.value < key) {
            root.right = delete(root.right, key)
        } else {
            // root.value == key
            // case1 no child
            if (root.left == null && root.right == null) {
                return null
            }

            // case2 one child
            if (root.left == null) {
                return root.right
            }
            if (root.right == null) {
                return root.left
            }

            // case 3 both child
            // replace key with inorder successor value and delete inorder successor

            val inorderSuccessor = getInorderSuccessor(root.right)

            root.value = inorderSuccessor.value
            delete(root.right, inorderSuccessor.value)
        }
        return root
    }

    // inorderSuccessor is left most node of right subtree
    fun getInorderSuccessor(node : BinarySearchTreeNode?): BinarySearchTreeNode {
            var inorderSuccessor: BinarySearchTreeNode? = node
            while (node?.left != null){
                inorderSuccessor = node.left
            }
            return inorderSuccessor!!
    }

    fun printInRange(x: Int, y: Int, root : BinarySearchTreeNode?){
        if(root == null) return

        if(root.value in x..y){
            print("${root.value} ")
            printInRange(x,y, root.left)
            printInRange(x,y, root.right)
        }
        else if(root.value >= y){
            printInRange(x,y, root.right)
        }else{
            printInRange(x,y, root.right)
        }

    }

    fun printRootTONode(root: BinarySearchTreeNode?,list : MutableIntList = MutableIntList()) {

        if(root == null) return
        list.add(root.value)

        //case if leaf note
        if(root.left == null && root.right == null){
            println()
            for(i in list.indices) {
                print("${list[i]} -> ")
            }

            println()
        }else{
            printRootTONode(root.left,list)
            printRootTONode(root.right,list)
        }
        if(list.size > 0) {
            list.removeAt(index = list.size-1)
        }

    }
    /**
     * Public-facing function to print all paths from the root to each leaf.
     * This function serves as a clean entry point.
     *
     * @param root The root node of the binary tree.
     */
    fun printRootToLeafPaths(root: BinarySearchTreeNode?) {
        // Starts the recursive process with a new, empty path list.
        printPathsRecursive(root, mutableListOf())
    }
    /**
     * A private helper function that recursively finds and prints paths.
     *
     * @param node The current node in the traversal.
     * @param currentPath A mutable list representing the path from the root to the current node.
     */
    private fun printPathsRecursive(node: BinarySearchTreeNode?, currentPath: MutableList<Int>) {
        // 1. Base case: Stop if the node is null
        if (node == null) {
            return
        }

        // 2. Add the current node's value to the path
        currentPath.add(node.value)

        // 3. Check if it's a leaf node
        if (node.left == null && node.right == null) {
            // If it is, print the path collected so far using idiomatic Kotlin
            println(currentPath.joinToString(" -> "))
        } else {
            // 4. If not a leaf, continue traversal down the left and right subtrees
            printPathsRecursive(node.left, currentPath)
            printPathsRecursive(node.right, currentPath)
        }

        // 5. Backtrack: Remove the current node from the path to explore other branches.
        // This is crucial for the algorithm to work correctly.
        currentPath.removeAt(currentPath.lastIndex)
    }


}