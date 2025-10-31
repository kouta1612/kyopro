from typing import List

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        ROWS, COLS = len(matrix), len(matrix[0])
        seen = set()
        r, c = 0, 0
        res = []
        while len(seen) < ROWS * COLS - 1:
            for dr, dc in dirs:
                while 0 <= r + dr < ROWS and 0 <= c + dc < COLS and (r + dr, c + dc) not in seen:
                    res.append(matrix[r][c])
                    seen.add((r, c))
                    r, c = r + dr, c + dc
        res.append(matrix[r][c])
        return res

print(Solution().spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))