# E - 散歩 (E869120 and Path Length)

## 反省

すべての計算でMODを取るとバグるので注意。
累積和を取る段階でMODをとることで歩く距離がマイナスになる可能性があるため。（下記コード参照）

```go
sum := make([]int, n)
 for i := 1; i < n; i++ {
  // 下記でMODをとるとsum[i]>sum[i-1]が常に成立するとは限らない
  sum[i] = (sum[i-1] + p[i]) % MOD
 }

 ans := (sum[c[0]] + sum[c[q-1]]) % MOD
 for i := 0; i < q-1; i++ {
  u, v := c[i], c[i+1]
  if u > v {
   u, v = v, u
  }
  // 上でMODを取ることでsum[v]-sum[u]<0の可能性があり、歩いた距離がマイナスになってしまう。
  ans = (ans + sum[v] - sum[u] + MOD) % MOD
}
```
