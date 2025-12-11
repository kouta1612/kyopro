from types import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [["."] * n for _ in range(n)]
        col, dir1, dir2 = set(), set(), set()

        def dfs(r: int):
            if r == n:
                res.append(["".join(row) for row in board])
                return
            for c in range(n):
                if c in col or (r + c) in dir1 or (r - c) in dir2:
                    continue
                col.add(c)
                dir1.add(r + c)
                dir2.add(r - c)
                board[r][c] = "Q"
                dfs(r + 1)
                col.remove(c)
                dir1.remove(r + c)
                dir2.remove(r - c)
                board[r][c] = "."
        
        dfs(0)
        return res

print(Solution().solveNQueens(4))