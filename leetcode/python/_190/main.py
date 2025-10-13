class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            res |= (n&1)<<(31-i)
            n = n>>1
        return res

print(Solution().reverseBits(43261596))