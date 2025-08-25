from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        keys = set()
        for num in nums:
            if num in keys:
                keys.remove(num)
            else:
                keys.add(num)
        return list(keys)[0]

print(Solution().singleNumber([4,1,2,1,2]))
