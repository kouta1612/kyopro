from typing import List
from collections import Counter

class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0: return False

        counter = Counter(hand)
        for x in sorted(counter):
            freq = counter[x]
            if freq <= 0: continue
            for i in range(groupSize):
                if counter[x + i] < freq: return False
                counter[x + i] -= freq
        return True
