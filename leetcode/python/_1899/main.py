from types import List

class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
        res = [0, 0, 0]
        x, y, z = target[0], target[1], target[2]
        for tx, ty, tz in triplets:
            if tx > x or ty > y or tz > z: continue
            res = [max(tx, res[0]), max(ty, res[1]), max(tz, res[2])]
        return res == target
