from typing import List, Optional

class TrieNode:
    def __init__(self):
        self.children = {}
        self.isWord = False

    def addWord(self, word: str):
        cur = self
        for c in word:
            if c not in cur.children:
                cur.children[c] = TrieNode()
            cur = cur.children[c]
        cur.isWord = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        root = TrieNode()
        for word in words: root.addWord(word)
        
        res = []
        ROWS, COLS = len(board), len(board[0])

        def dfs(r, c: int, node: Optional[TrieNode], word: str):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS: return
            if board[r][c] not in node.children: return

            node = node.children[board[r][c]]
            word += board[r][c]
            tmp = board[r][c]
            board[r][c] = "#"
            if node.isWord:
                res.append(word)
                node.isWord = False
            for dr, dc in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
                nr, nc = r + dr, c + dc
                dfs(nr, nc, node, word)
            board[r][c] = tmp
        
        for r in range(ROWS):
            for c in range(COLS):
                dfs(r, c, root, "")
        
        return res

print(Solution().findWords([["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], ["oath","pea","eat","rain"]))