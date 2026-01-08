from types import List

class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        cur = [1,1,1]
        for a, b, c in triplets:
            x, y, z = target
            if a > x or b > y or c > z: continue
            cur[0], cur[1], cur[2] = max(cur[0], a), max(cur[1], b), max(cur[2], c)
        return cur[0] == target[0] and cur[1] == target[1] and cur[2] == target[2]
