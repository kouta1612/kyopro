package main

import (
	"fmt"
	"math"
)

func main() {
	var n, m int
	fmt.Scan(&n, &m)

	g := make([][]int, n)
	for i := 0; i < n; i++ {
		g[i] = make([]int, m)
		for j := 0; j < m; j++ {
			fmt.Scan(&g[i][j])
		}
	}

	result := 0
	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if g[i][j] == 1 {
				dfs(i, j, 0, g, &result)
			}
		}
	}

	fmt.Println(result)
}

var dx = []int{0, -1, 0, 1}
var dy = []int{1, 0, -1, 0}

func dfs(x, y, cnt int, g [][]int, result *int) {
	cnt++
	*result = int(math.Max(float64(*result), float64(cnt)))
	g[x][y] = 0

	for i := 0; i < 4; i++ {
		nx, ny := dx[i]+x, dy[i]+y
		if 0 > nx || nx >= len(g) || 0 > ny || ny >= len(g[0]) {
			continue
		}
		if g[nx][ny] == 0 {
			continue
		}

		dfs(nx, ny, cnt, g, result)
	}

	g[x][y] = 1
}
