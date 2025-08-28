class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            if n & 1<<i:
                res += 1<<(31-i)
        return res

print(Solution().reverseBits(43261596))