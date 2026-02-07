from types import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        path = [["."] * n for _ in range(n)]
        y_dir, xy_left_dir, xy_right_dir = set(), set(), set()

        def dfs(r: int):
            if r == n: 
                cur = []
                for i in range(n): cur.append("".join(path[i]))
                res.append(cur)
                return

            for c in range(n):
                if c in y_dir: continue
                if r-c in xy_left_dir: continue
                if r+c in xy_right_dir: continue

                y_dir.add(c)
                xy_left_dir.add(r-c)
                xy_right_dir.add(r+c)
                path[r][c] = "Q"

                dfs(r+1)

                y_dir.remove(c)
                xy_left_dir.remove(r-c)
                xy_right_dir.remove(r+c)
                path[r][c] = "."
        dfs(0)
        return res

print(Solution().solveNQueens(4))