from typing import List

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        t, b = 0, len(matrix) - 1
        l, r = 0, len(matrix[0]) - 1
        res = []
        while t <= b and l <= r:
            for c in range(l, r + 1):
                res.append(matrix[t][c])
            t += 1
            for c in range(t, b + 1):
                res.append(matrix[c][r])
            r -= 1
            if not (t <= b and l <= r): break
            for c in range(r, l - 1, -1):
                res.append(matrix[b][c])
            b -= 1
            for c in range(b, t - 1, -1):
                res.append(matrix[c][l])
            l += 1
        return res

print(Solution().spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))
print(Solution().spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]))