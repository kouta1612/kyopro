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

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
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

	n, m := scanInt(), scanInt()
	a := make([]int, m)
	for i := 0; i < m; i++ {
		a[i] = scanInt() - 1
	}

	now := -1
	scores := make([]int, n)
	results := make([]int, m)
	for i := 0; i < m; i++ {
		scores[a[i]]++

		if i == 0 {
			now = a[i]
			results[i] = now
			continue
		}

		if scores[a[i]] == scores[now] {
			if a[i] < now {
				now = a[i]
			}
			results[i] = now
			continue
		}

		if scores[a[i]] > scores[now] {
			now = a[i]
			results[i] = now
			continue
		}

		if scores[a[i]] < scores[now] {
			results[i] = now
		}
	}

	for i := 0; i < m; i++ {
		fmt.Println(results[i] + 1)
	}
}
