package com.example.datastructureplayground.dsa.trie

fun main(){
    val words = arrayOf("apple","app","an","there","their")
    val trie = Trie()
    for (word in words){
        trie.insert(word)
    }
    println(trie.search("app"))
}

data class TrieNode(
    val children: MutableMap<Char, TrieNode?> = mutableMapOf(),
    var isEndOfWord: Boolean = false,
)

class Trie(){

    private val root = TrieNode()
    fun insert(word: String) {
        var current : TrieNode? = root
        for (char in word) {
            // Get the child node, creating it if it doesn't exist.
            // `getOrPut` is a concise way to do this.
            current = current?.children?.getOrPut(char) { TrieNode() }
        }
        // Mark the end of the word on the correct (final) node.
        current?.isEndOfWord = true
    }
    fun search(word: String): Boolean {
        var current : TrieNode? = root
        for (char in word) {
            // Traverse using the current node, not the root
            current = current?.children[char] ?: return false
        }
        // A word is found only if the path exists AND it's marked as an end of a word.
        return current?.isEndOfWord == true
    }
}