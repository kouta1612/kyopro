from typing import List
from collections import Counter

class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0: return False
        count = Counter(hand)
        for x in sorted(count):
            if count[x] <= 0: continue
            freq = count[x]
            for i in range(groupSize):
                if count[x+i] < freq: return False
                count[x+i] -= freq
        return True

print(Solution().isNStraightHand([1,2,3,6,2,3,4,7,8], 3))
print(Solution().isNStraightHand([1,2,3,4,5,6], 4))
print(Solution().isNStraightHand([1,2,3,4,5,6], 3))
print(Solution().isNStraightHand([1,2,3,4,5,6], 2))
print(Solution().isNStraightHand([1,2,3,4,5,6], 1))
print(Solution().isNStraightHand([1,2,3,4,5,6], 0))
print(Solution().isNStraightHand([1,2,3,4,5,6], 7))
print(Solution().isNStraightHand([1,2,3,4,5,6], 8))
print(Solution().isNStraightHand([1,2,3,4,5,6], 9))
print(Solution().isNStraightHand([1,2,3,4,5,6], 10))
print(Solution().isNStraightHand([1,2,3,4,5,6], 11))