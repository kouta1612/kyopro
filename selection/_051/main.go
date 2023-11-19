package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e16)
const MOD = 10007

var sc = bufio.NewScanner(os.Stdin)

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
}

func scanStr() string {
	sc.Scan()

	return sc.Text()
}

func min(n ...int) int {
	res := n[0]

	for _, v := range n {
		res = int(math.Min(float64(res), float64(v)))
	}

	return res
}

func max(n ...int) int {
	res := n[0]

	for _, v := range n {
		res = int(math.Max(float64(res), float64(v)))
	}

	return res
}

func abs(a int) int {
	return int(math.Abs(float64(a)))
}

func main() {
	sc.Split(bufio.ScanWords)

	n, s := scanInt(), scanStr()

	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, 1<<3)
	}
	dp[0][0] = 1

	m := map[byte]int{
		'J': 1 << 0,
		'O': 1 << 1,
		'I': 1 << 2,
	}

	// dp[i][bit]: i日目までのスケジュールの組み合わせのうち、i日目に参加者の集合bitの場合の場合の数
	for i := 1; i <= n; i++ {
		for bit := 0; bit < 1<<3; bit++ {
			if i == 1 && (bit&m['J']) == 0 {
				continue
			}
			if (bit & m[s[i-1]]) == 0 {
				continue
			}

			// i日の前日の参加者の組み合わせを全列挙
			for bit2 := 0; bit2 < 1<<3; bit2++ {
				if i != 1 && bit&bit2 == 0 {
					continue
				}

				dp[i][bit] = (dp[i][bit] + dp[i-1][bit2]) % MOD
			}
		}
	}

	result := 0
	for i := 0; i < 1<<3; i++ {
		result = (result + dp[n][i]) % MOD
	}

	fmt.Println(result)
}
