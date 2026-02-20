from collections import defaultdict
from typing import List

class DetectSquares:

    def __init__(self):
        self.ys = defaultdict(set)
        self.cnt = defaultdict(int)

    def add(self, point: List[int]) -> None:
        x, y = point
        self.cnt[(x, y)] += 1
        self.ys[x].add(y)

    def count(self, point: List[int]) -> int:
        px, py = point
        res = 0
        for y in self.ys[px]:
            if py == y: continue
            d = abs(py - y)
            res += self.cnt[(px-d, py)] * self.cnt[(px-d, y)] * self.cnt[(px, y)]
            res += self.cnt[(px+d, py)] * self.cnt[(px+d, y)] * self.cnt[(px, y)]
        return res

print(DetectSquares().count([3,4]))