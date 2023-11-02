package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

var sc = bufio.NewScanner(os.Stdin)

func scanInt() int {
	sc.Scan()

	res, err := strconv.Atoi(sc.Text())
	if err != nil {
		panic(err)
	}

	return res
}

func main() {
	sc.Split(bufio.ScanWords)

	n, q := scanInt(), scanInt()

	g := make([][]int, n)
	for i := 0; i < n; i++ {
		g[i] = make([]int, 0)
	}

	a, b, p, x := make([]int, n-1), make([]int, n-1), make([]int, q), make([]int, q)
	for i := 0; i < n-1; i++ {
		a[i], b[i] = scanInt()-1, scanInt()-1
		g[a[i]] = append(g[a[i]], b[i])
		g[b[i]] = append(g[b[i]], a[i])
	}

	for i := 0; i < q; i++ {
		p[i], x[i] = scanInt()-1, scanInt()
	}

	result := make([]int, n)
	for i := 0; i < q; i++ {
		result[p[i]] += x[i]
	}

	dfs(0, -1, g, result)

	for i := 0; i < n; i++ {
		fmt.Print(result[i], " ")
	}

	fmt.Println()
}

func dfs(n, p int, g [][]int, result []int) {
	for i := 0; i < len(g[n]); i++ {
		if g[n][i] == p {
			continue
		}

		result[g[n][i]] += result[n]
		dfs(g[n][i], n, g, result)
	}
}
