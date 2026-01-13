from types import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col_set = set()
        diagonal_left, diagonal_right = set(), set()
        board = [["."] * n for _ in range(n)]
        res = []

        def dfs(r: int):
            if r == n:
                res.append(["".join(board[i]) for i in range(n)])
                return
            for c in range(n):
                if c in col_set: continue
                if r + c in diagonal_right: continue
                if r - c in diagonal_left: continue

                col_set.add(c)
                diagonal_right.add(r + c)
                diagonal_left.add(r - c)
                board[r][c] = "Q"

                dfs(r + 1)

                col_set.remove(c)
                diagonal_right.remove(r + c)
                diagonal_left.remove(r - c)
                board[r][c] = "."
        dfs(0)
        return res

print(Solution().solveNQueens(4))