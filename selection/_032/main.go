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

type point struct {
	x, y int
}

var dx = []int{0, 1, 0, -1}
var dy = []int{1, 0, -1, 0}

func main() {
	sc.Split(bufio.ScanWords)

	results := make([]int, 0)

	for {
		y, x := scanInt(), scanInt()

		if x == 0 && y == 0 {
			break
		}

		partitionRight := make([][]int, x)
		for i := 0; i < x; i++ {
			partitionRight[i] = make([]int, y-1)
		}

		partitionUnder := make([][]int, x-1)
		for i := 0; i < x-1; i++ {
			partitionUnder[i] = make([]int, y)
		}

		for i := 0; i < 2*x-1; i++ {
			if i%2 == 0 {
				for j := 0; j < y-1; j++ {
					partitionRight[i/2][j] = scanInt()
				}
			} else {
				for j := 0; j < y; j++ {
					partitionUnder[i/2][j] = scanInt()
				}
			}
		}

		m := make([][]int, x)
		for i := 0; i < x; i++ {
			m[i] = make([]int, y)
		}

		q := make([]point, 0)
		q = append(q, point{x: 0, y: 0})
		m[0][0] = 1
		for len(q) > 0 {
			now := q[0]
			q = q[1:]

			for i := 0; i < 4; i++ {
				nx := now.x + dx[i]
				ny := now.y + dy[i]

				if nx < 0 || nx > x-1 || ny < 0 || ny > y-1 {
					continue
				}
				if m[nx][ny] != 0 {
					continue
				}
				// 下方向にしきりがある場合
				if dx[i] == 1 && dy[i] == 0 && partitionUnder[now.x][now.y] == 1 {
					continue
				}
				// 右方向にしきりがある場合
				if dx[i] == 0 && dy[i] == 1 && partitionRight[now.x][now.y] == 1 {
					continue
				}
				// 上方向にしきりがある場合
				if dx[i] == -1 && dy[i] == 0 && partitionUnder[nx][ny] == 1 {
					continue
				}

				m[nx][ny] = m[now.x][now.y] + 1
				q = append(q, point{x: nx, y: ny})
			}
		}

		results = append(results, m[x-1][y-1])
	}

	for i := 0; i < len(results); i++ {
		fmt.Println(results[i])
	}
}
