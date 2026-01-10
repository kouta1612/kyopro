from collections import defaultdict

class DetectSquares:

    def __init__(self):
        self.cnt = defaultdict(int)
        self.points_by_x = defaultdict(set)

    def add(self, point: List[int]) -> None:
        x, y = point
        self.cnt[(x, y)] += 1
        self.points_by_x[x].add((x, y))

    def count(self, point: List[int]) -> int:
        x, y = point
        res = 0
        for _, ny in self.points_by_x[x]:
            if ny == y: continue
            side = abs(ny - y)
            res += self.cnt[(x, ny)] * self.cnt[(x + side, ny)] * self.cnt[(x + side, y)]
            res += self.cnt[(x, ny)] * self.cnt[(x - side, ny)] * self.cnt[(x - side, y)]
        return res
