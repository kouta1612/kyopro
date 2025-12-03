from heapq import heappop, heapify
from collections import defaultdict
from typing import List

class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0: return False
        
        counter = defaultdict(int)
        for num in hand: counter[num] += 1
        heap = list(counter.keys())
        heapify(heap)

        while heap:
            first = heap[0]
            for i in range(first, first + groupSize):
                if i not in counter: return False
                counter[i] -= 1
                if counter[i] == 0: 
                    del counter[i]
                    if heappop(heap) != i: return False
        return True
