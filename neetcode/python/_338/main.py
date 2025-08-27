from typing import List

class Solution:
    def countBits(self, n: int) -> List[int]:
        res = []
        for i in range(n + 1):
            cnt, v = 0, i
            while v != 0:
                if v % 2 == 1:
                    cnt += 1
                v //= 2
            res += [cnt]
        return res

print(Solution().countBits(5))
