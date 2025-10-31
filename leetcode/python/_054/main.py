from typing import List

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ROWS, COLS = len(matrix), len(matrix[0])
        r, c = 0, 0
        seen = set()
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        dirv = 0
        res = []
        for _ in range(ROWS * COLS):
            res.append(matrix[r][c])
            seen.add((r, c))
            dr, dc = dirs[dirv]
            nr, nc = r + dr, c + dc
            if not (0 <= nr < ROWS and 0 <= nc < COLS and (nr, nc) not in seen):
                dirv = (dirv + 1) % 4
                dr, dc = dirs[dirv]
                nr, nc = r + dr, c + dc
            r, c = nr, nc
        return res

print(Solution().spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))