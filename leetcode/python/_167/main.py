from typing import List

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        n = len(numbers)
        l, r = 0, n - 1
        while l < r:
            if numbers[l] + numbers[r] == target: return [l + 1, r + 1]
            elif numbers[l] + numbers[r] > target: r -= 1
            else: l += 1
        return None

print(Solution().twoSum([2, 7, 11, 15], 9))