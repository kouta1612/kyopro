class SegmentTree:
    def __init__(self, n: int):
        self.n = 1
        while self.n < n: self.n *= 2
        self.data = [0] * (2 * self.n - 1)

    def update(self, i, x: int):
        i += self.n - 1
        while True:
            self.data[i] = max(self.data[i], x)
            if i == 0: break
            i = (i-1) // 2

    def query(self, ql, qr) -> int:
        return self._query(ql, qr, 0, 0, self.n)

    def _query(self, ql, qr, i, l, r) -> int:
        if qr <= l or r <= ql: return 0
        if ql <= l and r <= qr: return self.data[i]
        mid = (l + r) // 2
        lv, rv = self._query(ql, qr, 2*i+1, l, mid), self._query(ql, qr, 2*i+2, mid, r)
        return max(lv, rv)

n = int(input())
h = list(map(int, input().split()))
a = list(map(int, input().split()))

maxh = max(h)
seg = SegmentTree(maxh+1)

for i in range(n):
    best = seg.query(0, h[i])
    seg.update(h[i], best + a[i])

print(seg.query(0, maxh+1))