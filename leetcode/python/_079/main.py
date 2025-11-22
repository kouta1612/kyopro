from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        n = len(word)
        visited = set()

        def dfs(r, c, i: int) -> bool:
            if r < 0 or c < 0 or r >= ROWS or c >= COLS: return False
            if (r, c) in visited: return False
            if board[r][c] != word[i]: return False
            if i == n - 1: return True

            visited.add((r, c))
            for nr, nc in [[r+1, c], [r-1, c], [r, c+1], [r, c-1]]:
                if dfs(nr, nc, i + 1): return True
            visited.remove((r, c))
            
            return False
        
        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r, c, 0): return True
        return False

print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))