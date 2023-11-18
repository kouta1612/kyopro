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

	var n int
	var s string
	fmt.Scan(&n, &s)

	m := make(map[byte]int)
	l, r := 0, 0
	for l < n {
		for r < n {
			if s[l] == s[r] {
				r++
			} else {
				break
			}
		}

		m[s[l]] = max(m[s[l]], r-l)
		l = r
	}

	result := 0
	for _, v := range m {
		result += v
	}

	fmt.Println(result)
}
