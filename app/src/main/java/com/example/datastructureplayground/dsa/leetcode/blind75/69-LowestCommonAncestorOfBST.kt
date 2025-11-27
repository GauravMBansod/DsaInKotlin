package com.example.datastructureplayground.dsa.leetcode.blind75

import com.example.datastructureplayground.dsa.binarytree.BinarySearchTree
import com.example.datastructureplayground.dsa.binarytree.BinarySearchTreeNode

fun main(){
    val bst = BinarySearchTree()

    for( i in arrayOf(6,2,8,0,4,7,9,3,5)){
       bst.root = bst.insert(bst.root,i)
    }

    val lca = commonAncestorBST(2,8,bst.root)
    println("lca : ${lca?.value}")

}

fun commonAncestorBST(n1 : Int, n2: Int,root: BinarySearchTreeNode?) : BinarySearchTreeNode?{

    val min = minOf(n1,n2)
    val max= maxOf(n1,n2)
    var current = root

    while (current != null){
        if (current.value > max) { // If current node's value is greater than both n1 and n2, LCA must be in the left subtree.
            current = current.left

        } else if (current.value < min) { // If current node's value is smaller than both n1 and n2, LCA must be in the right subtree.
            current = current.right
        } else { // This is the split point or one of the nodes is the ancestor. This is the LCA.
            return current
        }
    }

    return null

}

/*Practice - Lowest Common Ancestor of a BST
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.



According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”




Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8

Output: 6

Explanation: The LCA of nodes 2 and 8 is 6.



Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4

Output: 2

Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.



Example 3:

Input: root = [2,1], p = 2, q = 1

Output: 2


Constraints:

The number of nodes in the tree is in the range [2, 105].

-109 <= Node.val <= 109

All Node.val are unique.

p != q

p and q will exist in the BST.*/