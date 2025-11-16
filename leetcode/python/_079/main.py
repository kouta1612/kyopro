from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])
        seen = set()

        def dfs(i, j, k: int) -> bool:
            if k == len(word): return True
            if i < 0 or j < 0 or i >= ROWS or j >= COLS: return False
            if (i, j) in seen: return False
            if word[k] != board[i][j]: return False

            seen.add((i, j))
            for ni, nj in [[i+1, j], [i-1, j], [i, j+1], [i, j-1]]:
                if dfs(ni, nj, k+1): return True
            seen.remove((i, j))
            return False
        
        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r, c, 0): return True
        return False

print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(Solution().exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))