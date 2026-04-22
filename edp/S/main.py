MOD = 10**9+7

K = input()
D = int(input())
n = len(K)

dp = [[[0] * 2 for _ in range(D)] for _ in range(n+1)]
dp[0][0][1] = 1

for i in range(n):
    for mod in range(D):
        for tight in range(2):
            if dp[i][mod][tight] == 0: continue
            limit = int(K[i]) if tight else 9
            for d in range(limit+1):
                nmod = (mod+d)%D
                ntight = tight and (d == limit)
                dp[i+1][nmod][ntight] += dp[i][mod][tight]
                dp[i+1][nmod][ntight] %= MOD
print((dp[n][0][0] + dp[n][0][1] - 1) % MOD)