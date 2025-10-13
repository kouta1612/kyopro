class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(16):
            if 1<<i & n > 0: res += 1<<(31-i)
            if 1<<(31-i) & n > 0: res += 1<<i
        return res

print(Solution().reverseBits(43261596))