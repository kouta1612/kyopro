from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        top, bottom = 0, ROWS - 1
        while top < bottom:
            mid = (top + bottom) // 2
            if target == matrix[mid][0]: return True
            elif target < matrix[mid][0]: bottom = mid - 1
            elif target <= matrix[mid][COLS - 1]: top = mid
            else: top = mid + 1
        left, right = 0, COLS - 1
        while left <= right:
            mid = (left + right) // 2
            if target == matrix[top][mid]: return True
            elif target < matrix[top][mid]: right = mid - 1
            else: left = mid + 1
        return False

print(Solution().searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))