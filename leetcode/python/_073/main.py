from typing import List

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        rowSet, colSet = set(), set()
        ROWS, COLS = len(matrix), len(matrix[0])
        for i in range(ROWS):
            for j in range(COLS):
                if matrix[i][j] == 0:
                    rowSet.add(i)
                    colSet.add(j)
        for r in rowSet:
            for c in range(COLS):
                matrix[r][c] = 0
        for c in colSet:
            for r in range(ROWS):
                matrix[r][c] = 0

print(Solution().setZeroes([[1,1,1],[1,0,1],[1,1,1]]))