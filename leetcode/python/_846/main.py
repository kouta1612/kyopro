from heapq import heappop, heappush
from collections import defaultdict
from typing import List

class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0: return False
        
        counter = defaultdict(int)
        for num in hand: counter[num] += 1
        heap = []
        for key in counter.keys(): heappush(heap, key)

        while heap:
            key = heappop(heap)
            heappush(heap, key)
            for num in range(key, key + groupSize):
                if num not in counter: return False
                counter[num] -= 1
                if counter[num] == 0: 
                    del counter[num]
                    if heappop(heap) != num: return False
        return True
