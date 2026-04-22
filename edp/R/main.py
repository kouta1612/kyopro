from typing import List

MOD = 10**9+7

def power(x: List[List[int]], k: int) -> List[List[int]]:
    res = [[0] * n for _ in range(n)]
    for i in range(n): res[i][i] = 1

    while k > 0:
        if k&1: res = prod(res, x)
        x = prod(x, x)
        k >>= 1

    return res

def prod(x, y: List[List[int]]) -> List[List[int]]:
    res = [[0] * n for _ in range(n)]
    for i in range(n):
        for k in range(n):
            if x[i][k] == 0: continue
            for j in range(n):
                res[i][j] += x[i][k] * y[k][j]
                res[i][j] %= MOD
    return res

n, k = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

ak = power(a, k)
res = 0
for i in range(n):
    for j in range(n):
        res += ak[i][j]
        res %= MOD
print(res)