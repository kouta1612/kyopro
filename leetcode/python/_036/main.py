from typing import List
from collections import defaultdict

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        ROWS, COLS = len(board), len(board)
        rset, cset = [set() for _ in range(ROWS)], [set() for _ in range(COLS)]
        bset = [[set() for _ in range(3)] for _ in range(3)]
        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == ".": continue
                if board[r][c] in rset[r]: return False
                if board[r][c] in cset[c]: return False
                if board[r][c] in bset[r//3][c//3]: return False
                rset[r].add(board[r][c])
                cset[c].add(board[r][c])
                bset[r//3][c//3].add(board[r][c])
        return True

print(Solution().isValidSudoku([
    ["5","3",".",".","7",".",".",".","."],
    ["6",".",".","1","9","5",".",".","."],
    [".","9","8",".",".",".",".","6","."],
    ["8",".",".",".","6",".",".",".","3"],
    ["4",".",".","8",".","3",".",".","1"],
    ["7",".",".",".","2",".",".",".","6"],
    [".","6",".",".",".",".","2","8","."],
    [".",".",".","4","1","9",".",".","5"],
    [".",".",".",".","8",".",".","7","9"]
]))