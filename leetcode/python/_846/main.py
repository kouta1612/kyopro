from typing import List
from collections import Counter

class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        n = len(hand)
        if n % groupSize != 0: return False

        counter = Counter(hand)
        for v in sorted(list(set(hand))):
            if v not in counter: continue
            if counter[v] == 0: continue
            x = counter[v]
            for i in range(groupSize):
                if v+i not in counter: return False
                if counter[v+i] < x: return False
                counter[v+i] -= x
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