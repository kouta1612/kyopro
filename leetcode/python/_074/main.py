from typing import List

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        top, bottom = 0, ROWS - 1
        while top < bottom:
            mid = (top + bottom) // 2
            if matrix[mid][0] > target:
                bottom = mid - 1
            elif matrix[mid][COLS - 1] >= target:
                bottom = mid
            else:
                top = mid + 1
        if top > bottom: return False
        l, r = 0, COLS - 1
        while l <= r:
            mid = (l + r) // 2
            if matrix[top][mid] == target: return True
            elif matrix[top][mid] < target: l = mid + 1
            else: r = mid - 1
        return False

print(Solution().searchMatrix([[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3))