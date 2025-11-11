from typing import List

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        ROWS, COLS = len(matrix), len(matrix[0])
        for i in range(ROWS - 1):
            for j in range(i + 1, COLS):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        for i in range(ROWS):
            matrix[i].reverse()

matrix = [[1,2,3],[4,5,6],[7,8,9]]
Solution().rotate(matrix)
print(matrix)