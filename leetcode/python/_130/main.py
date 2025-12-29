from typing import List

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        ROWS, COLS = len(board), len(board[0])
        def dfs(i, j: int):
            if i < 0 or j < 0 or i >= ROWS or j >= COLS: return
            if board[i][j] == "X" or board[i][j] == "T": return
            if board[i][j] == "O": board[i][j] = "T"

            for ni, nj in [[i+1, j], [i, j+1], [i-1, j], [i, j-1]]:
                dfs(ni, nj)
        
        for i in range(ROWS):
            if board[i][0] == "O": dfs(i, 0)
            if board[i][COLS-1] == "O": dfs(i, COLS-1)
        for j in range(COLS):
            if board[0][j] == "O": dfs(0, j)
            if board[ROWS-1][j] == "O": dfs(ROWS-1, j)
        
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == "O": board[i][j] = "X"
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == "T": board[i][j] = "O"

print(Solution().solve([["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]))