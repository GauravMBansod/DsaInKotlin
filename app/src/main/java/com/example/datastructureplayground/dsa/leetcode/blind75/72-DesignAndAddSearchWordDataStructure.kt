package com.example.datastructureplayground.dsa.leetcode.blind75

fun main(){
    val trie = Trie1()
    val words = arrayOf("WordDictionary","bad","dad","addWord","search","search","search","search")

    for(word in words){
        trie.insert(word)
    }

    println(trie.search("pad"))
    println(trie.search("bad"))
    println(trie.search(".ad"))
    println(trie.search("b.."))

}

data class TrieNode1(
    var children : MutableMap<Char, TrieNode1> = mutableMapOf<Char, TrieNode1>(),
    var isEndWord : Boolean = false
)

private class Trie1(){
    private var root = TrieNode1()
    fun insert(word: String){
        var current : TrieNode1? = root
        for(char in word) {
            if (current?.children?.contains(char) == false) {
                current.children[char] = TrieNode1()
            }
            current = current?.children[char]
        }
        current?.isEndWord = true
    }

    fun search(word: String): Boolean {
        return searchWord(word, index = 0, root = root)
    }

    fun searchWord(word: String,index:Int,root:TrieNode1? ):Boolean {
        if(root == null) return false
        if(index == word.length) return root.isEndWord

        if (word[index] == '.') {
            for (child in root.children.keys) {
                 if (searchWord(word, index + 1, root.children[child])) {
                     return  true
                }
            }
        }else{
            return searchWord(word, index + 1, root.children[word[index]])
        }
        return false
    }// TC: O(n^2), SC: O(n)
}


/*Practice - Design Add and Search Words Data Structure

Design a data structure that allows adding new words and searching for matches, where a dot '.' in the search word can match any letter.

Implement the WordDictionary class:

WordDictionary(): Initializes the object.

void addWord(word): Adds word to the data structure for later matching.

bool search(word): Returns true if any string in the data structure matches word, considering dots '.' as placeholders for any letter.

Example:

Input

["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output

[null,null,null,null,false,true,true,true]
* */
