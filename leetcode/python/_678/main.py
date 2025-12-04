class Solution:
    def checkValidString(self, s: str) -> bool:
        dp = {}

        def dfs(i, leftCount: int) -> bool:
            if leftCount < 0: return False
            if i == len(s): return leftCount == 0
            if (i, leftCount) in dp: return dp[(i, leftCount)]

            if s[i] == "(": 
                dp[(i, leftCount)] = dfs(i + 1, leftCount + 1)
                return dp[(i, leftCount)]
            elif s[i] == ")": 
                dp[(i, leftCount)] = dfs(i + 1, leftCount - 1)
                return dp[(i, leftCount)]
            dp[(i, leftCount)] = (
                dfs(i + 1, leftCount + 1) or
                dfs(i + 1, leftCount - 1) or
                dfs(i + 1, leftCount)
            )
            return dp[(i, leftCount)]
        return dfs(0, 0)
