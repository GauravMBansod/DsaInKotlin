package com.example.datastructureplayground.dsa.leetcode.blind75



fun main(){
    val trie = Trie()
    val words = arrayOf("apple","app","an","there","their")

    for (word in words){
      trie.insert(word)
    }

    println(trie.search("apple"))
    println(trie.search("ap"))
    println(trie.isPrefix("ap"))
    println(trie.isPrefix("an"))


}
data class TrieNode(
    val children: MutableMap<Char, TrieNode> = mutableMapOf(),
    var isEnd: Boolean = false,
)
class Trie(){
    val root : TrieNode = TrieNode()

    fun insert(word: String) {
        var current : TrieNode? = root
        for (char in word) {
            // Get the child node, creating it if it doesn't exist.
            // `getOrPut` is a concise way to do this.
            current = current?.children?.getOrPut(char) { TrieNode() }
        }
        // Mark the end of the word on the correct (final) node.
        current?.isEnd = true
    }

    fun search(word: String): Boolean {
        var currentNode: TrieNode? = root
        for (char in word) {
            // Traverse to the next node in the path.
            currentNode = currentNode?.children?.get(char)
            // If at any point the node is null, the path doesn't exist.
            if (currentNode == null) return false
        }
        return currentNode?.isEnd == true
    }


    fun isPrefix(word: String): Boolean {
        var currentNode: TrieNode? = root
        for (char in word) {
            // Traverse to the next node in the path.
            currentNode = currentNode?.children?.get(char)
            // If at any point the node is null, the path doesn't exist.
            if (currentNode == null) return false
        }
        return true
    }

}

/*
Practice - Implement Trie (Prefix Tree)

A Trie, also known as a prefix tree, is a tree-based data structure primarily used for efficient storage and retrieval of keys in a set of strings. It finds applications in tasks such as autocomplete suggestions and spell checking.

Here's the implementation of the Trie class with its methods:

Trie(): Initializes an empty trie object.

void insert(String word): Inserts the string word into the trie.

boolean search(String word): Returns true if the string word is present in the trie (i.e., it was inserted before), otherwise returns false.

boolean startsWith(String prefix): Returns true if there exists a previously inserted string word that has the prefix prefix, otherwise returns false. Example 1:

Input:

["Trie", "insert", "search", "search", "startsWith", "insert", "search"]

[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

Output:

[null, null, true, false, true, null, true]



Explanation

Trie trie = new Trie();

trie.insert("apple");

trie.search("apple");   // return True

trie.search("app");     // return False

trie.startsWith("app"); // return True

trie.insert("app");

trie.search("app");     // return True




Constraints:

1 <= word.length, prefix.length <= 2000

word and prefix consist only of lowercase English letters.

At most 3 * 104 calls in total will be made to insert, search, and startsWith.
* */