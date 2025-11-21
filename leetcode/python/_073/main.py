from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        ROWS, COLS = len(matrix), len(matrix[0])
        FIRST_ROW_ZERO, FIRST_COL_ZERO = False, False
        for r in range(ROWS):
            if matrix[r][0] == 0:
                FIRST_COL_ZERO = True
                break
        for c in range(COLS):
            if matrix[0][c] == 0:
                FIRST_ROW_ZERO = True
                break
        for r in range(1, ROWS):
            for c in range(1, COLS):
                if matrix[r][c] == 0:
                    matrix[r][0] = matrix[0][c] = 0
        for r in range(1, ROWS):
            if matrix[r][0] == 0:
                for c in range(1, COLS):
                    matrix[r][c] = 0
        for c in range(1, COLS):
            if matrix[0][c] == 0:
                for r in range(1, ROWS):
                    matrix[r][c] = 0
        if FIRST_ROW_ZERO:
            for c in range(COLS):
                matrix[0][c] = 0
        if FIRST_COL_ZERO:
            for r in range(ROWS):
                matrix[r][0] = 0

print(Solution().setZeroes([[1,1,1],[1,0,1],[1,1,1]]))