from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        counts = dict()
        for num in nums:
            if num not in counts.keys():
                counts[num] = 1
            else:
                counts[num] += 1

        res = -1
        for key, val in counts.items():
            if val == 1:
                return key
        return -1

print(Solution().singleNumber([4,1,2,1,2]))
