class Solution:
    def hammingWeight(self, n: int) -> int:
        res = 0
        for i in range(32):
            if n & 1<<i > 0: res += 1
        return res

print(Solution().hammingWeight(11))