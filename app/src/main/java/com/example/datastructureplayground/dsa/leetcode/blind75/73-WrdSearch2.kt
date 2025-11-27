package com.example.datastructureplayground.dsa.leetcode.blind75


fun main() {
    val board = arrayOf(charArrayOf('o','a','a','n'),charArrayOf('e','t','a','e'),charArrayOf('i','h','k','r'),charArrayOf('i','f','l','v'))
    val words = arrayOf("oath","pea","eat","rain")
    val sol = Solution()
    val result = sol.findWords(board,words)
    println(result)
}
 class Solution {
    class Node {
        var child: HashMap<Char?, Node> = HashMap<Char?, Node>()
        var word: String? = null
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): MutableList<String?> {
        val list: MutableList<String?> = ArrayList<String?>()
        val root = buildTrie(words)
        for (i in board.indices) {
            for (j in board[i].indices) {
                dfs(board, list, root, i, j)
            }
        }
        return list
    }

    fun dfs(board: Array<CharArray>, list: MutableList<String?>, curr: Node, i: Int, j: Int) {
        var curr = curr
        if (i < 0 || j < 0 || i >= board.size || j >= board[0].size) return

        val ch = board[i][j]

        if (ch == '#' || curr.child.get(ch) == null) return
        curr = curr.child.get(ch)!!
        if (curr.word != null) {
            list.add(curr.word)
            curr.word = null
        }

        board[i][j] = '#'
        // top, left, down, right
        dfs(board, list, curr, i - 1, j)
        dfs(board, list, curr, i, j - 1)
        dfs(board, list, curr, i + 1, j)
        dfs(board, list, curr, i, j + 1)
        board[i][j] = ch
    }

    fun buildTrie(words: Array<String>): Node {
        val root: Node = Node()
        for (word in words) {
            var curr = root
            for (i in 0..<word.length) {
                val ch = word[i]
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, Node())
                }
                curr = curr.child.get(ch)!!
            }
            curr.word = word
        }
        return root
    }
}

/*Practice - Word Search II
Given an m x n board of characters and a list of strings words, return all words on the board. Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word. Example 1:

 Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"] Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"] Output: [] Constraints:

m == board.length

n == board[i].length

1 <= m, n <= 12

board[i][j] is a lowercase English letter.

1 <= words.length <= 3 * 104

1 <= words[i].length <= 10

words[i] consists of lowercase English letters.

All the strings of words are unique.*/