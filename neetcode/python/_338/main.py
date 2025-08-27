from typing import List

class Solution:
    def countBits(self, n: int) -> List[int]:
        res = []
        for i in range(n + 1):
            cnt = 0
            for j in range(32):
                if i & 1<<j:
                    cnt += 1
            res.append(cnt)
        return res


print(Solution().countBits(5))
