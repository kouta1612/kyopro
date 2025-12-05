from types import List

class DetectSquares:
    def __init__(self):
        self.pc = {}

    def add(self, point: List[int]) -> None:
        self.pc[tuple(point)] = 1 + self.pc.get(tuple(point), 0)

    def count(self, point: List[int]) -> int:
        res = 0
        x, y = point
        for p, n in self.pc.items():
            px, py = p
            if abs(px - x) != abs(py - y) or px == x or py == y:
                continue
            res += self.pc.get((x, py), 0) * self.pc.get((px, y), 0) * self.pc.get((px, py), 0)
        return res
