from types import List

class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        s = set()
        for t in triplets:
            x, y, z = target
            if t[0] > x or t[1] > y or t[2] > z: continue
            for i, v in enumerate(target):
                if t[i] == v: s.add(i)
        return len(s) == 3
