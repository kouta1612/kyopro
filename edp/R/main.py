from typing import List

MOD = 10**9+7

n, k = map(int, input().split())
a = [list(map(int, input().split())) for _ in range(n)]

def mod_prod(x: List[List[int]], y: List[List[int]]) -> List[List[int]]:
    res = [[0] * n for _ in range(n)]
    for i in range(n):
        for k in range(n):
            if x[i][k] == 0: continue
            for j in range(n):
                res[i][j] += x[i][k] * y[k][j]
                res[i][j] %= MOD
    return res

def mod_power(x: List[List[int]], p: int) -> List[List[int]]:
    res = [[0] * n for _ in range(n)]
    for i in range(n): res[i][i] = 1
    while p > 0:
        if p&1: res = mod_prod(res, x)
        x = mod_prod(x, x)
        p >>= 1
    return res

matrix = mod_power(a, k)
res = 0
for i in range(n):
    for j in range(n):
        res += matrix[i][j]
        res %= MOD
print(res)