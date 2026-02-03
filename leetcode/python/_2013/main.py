from collections import defaultdict
from typing import List

class DetectSquares:

    def __init__(self):
        self.xs = defaultdict(set)
        self.xys = defaultdict(int)

    def add(self, point: List[int]) -> None:
        x,y = point
        self.xs[x].add(y)
        self.xys[(x,y)] += 1

    def count(self, point: List[int]) -> int:
        res = 0
        x, y = point
        for ny in self.xs[x]:
            if y == ny: continue
            side = y - ny
            res += self.xys[(x,ny)] * self.xys[(x-side, ny)] * self.xys[(x-side, y)]
            res += self.xys[(x,ny)] * self.xys[(x+side, ny)] * self.xys[(x+side, y)]
        return res

print(DetectSquares().count([3,4]))