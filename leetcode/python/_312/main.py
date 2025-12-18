from types import List

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        dp = {}

        def dfs(l, r: int) -> int:
            if l > r: return 0
            if (l, r) in dp: return dp[(l, r)]

            dp[(l, r)] = 0
            for i in range(l, r + 1):
                s = nums[l - 1] * nums[i] * nums[r + 1]
                s += dfs(l, i - 1) + dfs(i + 1, r)
                dp[(l, r)] = max(dp[(l, r)], s)
            
            return dp[(l, r)]

        return dfs(1, len(nums) - 2)

print(Solution().maxCoins([3,1,5,8]))