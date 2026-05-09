class segtree:
    def __init__(self, n: int):
        self.n = 1
        while self.n < n: self.n *= 2
        self.datas = [0] * (2 * self.n)

    def query(self, ql: int, qr: int) -> int:
        return self._query(ql, qr, 0, self.n, 0)
    
    def _query(self, ql: int, qr: int, l: int, r: int, i: int) -> int:
        if qr <= l or r <= ql: return 0
        if ql <= l and r <= qr: return self.datas[i]
        mid = (l+r)//2
        vl, vr = self._query(ql, qr, l, mid, 2*i+1), self._query(ql, qr, mid, r, 2*i+2)
        return max(vl, vr)
    
    def update(self, i: int, x: int):
        i += self.n - 1
        self.datas[i] = x
        while i > 0:
            i = (i-1)//2
            self.datas[i] = max(self.datas[2*i+1], self.datas[2*i+2])

n = int(input())
h = list(map(int, input().split()))
a = list(map(int, input().split()))

MAX_H = max(h)
seg = segtree(MAX_H+1)
for i in range(n):
    best = seg.query(0, h[i])
    seg.update(h[i], best + a[i])

print(seg.query(0, MAX_H+1))