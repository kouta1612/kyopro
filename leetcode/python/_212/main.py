from typing import List, Optional

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False

    def add(self, word: str):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isWord = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        ROWS, COLS = len(board), len(board[0])
        trie = TrieNode()
        for word in words: trie.add(word)

        res, seen = set(), set()
        def dfs(i, j: int, cur: str, node: Optional[TrieNode]):
            if i < 0 or j < 0 or i >= ROWS or j >= COLS: return
            if (i, j) in seen: return
            c = board[i][j]
            if c not in node.children: return

            cur += c
            node = node.children[c]
            if node.isWord: res.add(cur)
            seen.add((i, j))
            for ni, nj in [[i+1, j], [i-1, j], [i, j+1], [i, j-1]]:
                dfs(ni, nj, cur, node)
            seen.remove((i, j))
        for r in range(ROWS):
            for c in range(COLS):
                dfs(r, c, "", trie)
        return list(res)

print(Solution().findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], ["oath","pea","eat","rain"]))