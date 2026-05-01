class segtree:
    def __init__(self, n: int):
        self.n = 1
        while self.n < n: self.n *= 2
        self.nodes = [0] * (self.n * 2)

    def query(self, ql: int, qr: int) -> int:
        return self._query(0, self.n, 0, ql, qr)
    
    def _query(self, l: int, r: int, i: int, ql: int, qr: int) -> int:
        if r <= ql or qr <= l: return 0
        if ql <= l and r <= qr: return self.nodes[i]
        mid = (l+r) // 2
        vl, vr = self._query(l, mid, 2*i+1, ql, qr), self._query(mid, r, 2*i+2, ql, qr)
        return max(vl, vr)

    def update(self, i: int, x: int):
        i += self.n - 1
        self.nodes[i] = x
        while i > 0:
            i = (i-1)//2
            self.nodes[i] = max(self.nodes[2*i+1], self.nodes[2*i+2])
    
N = int(input())
h, a = list(map(int, input().split())), list(map(int, input().split()))

MAX_H = max(h)
seg = segtree(MAX_H+1)
for i in range(N):
    best = seg.query(0, h[i])
    seg.update(h[i], best + a[i])

print(seg.query(0, seg.n))