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

	d := scanInt()
	ans := INF

	rd := sqrt(d) + 1
	for x := 0; x <= rd; x++ {
		c := x*x - d

		if c >= 0 {
			ans = min(ans, abs(x*x-d))
		} else {
			y := sqrt(-c)
			ans = min(ans, abs(x*x+y*y-d))
			ans = min(ans, abs(x*x+(y+1)*(y+1)-d))
		}
	}

	fmt.Println(ans)
}

func sqrt(x int) int {
	return int(math.Sqrt(float64(x)))
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
