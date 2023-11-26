package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

const INF = int(1e16)

var sc = bufio.NewScanner(os.Stdin)

func main() {
	sc.Split(bufio.ScanWords)

	n := scanInt()
	m := make([]string, n)
	for i := 0; i < n; i++ {
		m[i] = scanStr()
	}

	r, c := make([]int, n), make([]int, n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if m[i][j] == 'o' {
				r[i]++
				c[j]++
			}
		}
	}

	ans := 0
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if m[i][j] == 'o' {
				ans += (r[i] - 1) * (c[j] - 1)
			}
		}
	}

	fmt.Println(ans)
}

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

// a[i] >= v を満たす最小のインデックスを取得する
func lowerBound(a []int, v int) int {
	ng, ok := -1, len(a)
	for ok-ng > 1 {
		mid := (ok + ng) / 2
		if a[mid] >= v {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
}

// a[i] > v を満たす最小のインデックスを取得する
func upperBound(a []int, v int) int {
	ng, ok := -1, len(a)
	for ok-ng > 1 {
		mid := (ok + ng) / 2
		if a[mid] > v {
			ok = mid
		} else {
			ng = mid
		}
	}

	return ok
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
