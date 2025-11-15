from typing import List, Optional

class TrieNode:
    def __init__(self):
        self.children = {}
        self.word = False

    def add(self, word: str):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.word = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        ROWS, COLS = len(board), len(board[0])
        trie = TrieNode()
        for word in words: trie.add(word)
        
        res = []

        def dfs(i, j: int, node: Optional[TrieNode], word: str):
            if i < 0 or j < 0 or i >= ROWS or j >= COLS: return
            c = board[i][j]
            if c == "#": return
            if c not in node.children: return

            word += c
            node = node.children[c]
            if node.word: 
                res.append(word)
                node.word = False
            board[i][j] = "#"
            for ni, nj in [[i + 1, j], [i - 1, j], [i, j + 1], [i, j - 1]]:
                dfs(ni, nj, node, word)
            board[i][j] = c

        for i in range(ROWS):
            for j in range(COLS):
                dfs(i, j, trie, "")
        return res

print(Solution().findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], ["oath","pea","eat","rain"]))