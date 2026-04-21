n = int(input())
h = list(map(int, input().split()))
a = list(map(int, input().split()))

maxh = max(h)
fenwick = [0] * (maxh+1)

def update(i, x: int):
    while i <= maxh:
        fenwick[i] = max(fenwick[i], x)
        i += i&-i

def query(i: int) -> int:
    res = 0

    while i > 0:
        res = max(res, fenwick[i])
        i -= i&-i

    return res

for i in range(n):
    best = query(h[i]-1)
    update(h[i], best+a[i])

print(query(maxh))