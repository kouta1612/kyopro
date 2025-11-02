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
        root = TrieNode()
        for word in words:
            root.add(word)
        
        res, visited = set(), set()
        ROWS, COLS = len(board), len(board[0])

        def dfs(r, c: int, node: Optional[TrieNode], word: str):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS: return
            if (r, c) in visited: return
            if board[r][c] not in node.children: return

            visited.add((r, c))
            node = node.children[board[r][c]]
            word += board[r][c]
            if node.word: res.add(word)
            for dr, dc in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                dfs(r + dr, c + dc, node, word)
            visited.remove((r, c))
        
        for i in range(ROWS):
            for j in range(COLS):
                dfs(i, j, root, "")
        
        return list(res)

print(Solution().findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], ["oath","pea","eat","rain"]))