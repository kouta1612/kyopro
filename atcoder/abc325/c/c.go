package main

import (
	"fmt"
	"strings"
)

var dx []int = []int{1, 1, 0, -1, -1, -1, 0, 1}
var dy []int = []int{0, 1, 1, 1, 0, -1, -1, -1}

func main() {
	var h, w int
	fmt.Scan(&h, &w)

	s := make([][]string, h)
	for i := 0; i < h; i++ {
		var row string
		fmt.Scan(&row)

		s[i] = strings.Split(row, "")
	}

	result := 0
	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if s[i][j] == "#" {
				dfs(s, i, j, h, w)
				result++
			}
		}
	}

	fmt.Println(result)
}

func dfs(s [][]string, x, y, h, w int) {
	s[x][y] = "."
	for i := 0; i < 8; i++ {
		nx := x + dx[i]
		ny := y + dy[i]
		if nx < 0 || nx >= h || ny < 0 || ny >= w {
			continue
		}
		if s[nx][ny] == "#" {
			dfs(s, nx, ny, h, w)
		}
	}
}
