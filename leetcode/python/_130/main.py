from typing import List

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS, COLS = len(board), len(board[0])
        for r in range(ROWS):
            if board[r][0] == "O": board[r][0] = "T"
            if board[r][COLS-1] == "O": board[r][COLS-1] = "T"
        for c in range(COLS):
            if board[0][c] == "O": board[0][c] = "T"
            if board[ROWS-1][c] == "O": board[ROWS-1][c] = "T"
        
        def dfs(r, c: int):
            for nr, nc in [[r+1, c], [r, c+1], [r-1, c], [r, c-1]]:
                if nr < 0 or nc < 0 or nr >= ROWS or nc >= COLS: continue
                if board[nr][nc] != "O": continue
                board[nr][nc] = "T"
                dfs(nr, nc)

        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == "T": dfs(r, c)
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == "O": board[r][c] = "X"
                elif board[r][c] == "T": board[r][c] = "O"

print(Solution().solve([["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]))