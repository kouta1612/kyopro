from typing import List

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n = len(s)
        res = []
        path = []

        def dfs(start: int):
            if start == n:
                res.append(path[:])
                return
            for end in range(start, n):
                if palindrome(start, end):
                    path.append(s[start:end+1])
                    dfs(end+1)
                    path.pop()
        
        def palindrome(l, r: int):
            while l < r:
                if s[l] != s[r]: return False
                l += 1
                r -= 1
            return True

        dfs(0)
        return res

print(Solution().partition("aab"))