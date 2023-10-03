package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	sc := bufio.NewScanner(os.Stdin)
	p := make([][][]string, 3)
	for i := 0; i < 3; i++ {
		p[i] = make([][]string, 4)
		for j := 0; j < 4; j++ {
			sc.Scan()
			p[i][j] = strings.Split(sc.Text(), "")
		}
	}

	for i := 0; i < 4; i++ {
		for j := 0; j < 4; j++ {
			all := getAll(p)
			if isOk(all) {
				fmt.Println("Yes")
				return
			}
			rotate(p[2])
		}
		rotate(p[1])
	}

	fmt.Println("No")
}

func isOk(inputs [][][][]string) bool {
	for i := 0; i < len(inputs[0]); i++ {
		for j := 0; j < len(inputs[1]); j++ {
			for k := 0; k < len(inputs[2]); k++ {
				if isPut([][][]string{inputs[0][i], inputs[1][j], inputs[2][k]}) {
					return true
				}
			}
		}
	}
	return false
}

func isPut(inputs [][][]string) bool {
	g := [][]string{{".", ".", ".", "."}, {".", ".", ".", "."}, {".", ".", ".", "."}, {".", ".", ".", "."}}
	for k := 0; k < 3; k++ {
		for i := 0; i < 4; i++ {
			for j := 0; j < 4; j++ {
				if inputs[k][i][j] == "." {
					continue
				}
				if g[i][j] == "#" {
					return false
				}
				g[i][j] = "#"
			}
		}
	}

	for i := 0; i < 4; i++ {
		for j := 0; j < 4; j++ {
			if g[i][j] == "." {
				return false
			}
		}
	}

	return true
}

func getAll(p [][][]string) [][][][]string {
	result := make([][][][]string, 3)
	for k := 0; k < 3; k++ {
		result[k] = [][][]string{}
		for dx := -3; dx <= 3; dx++ {
			for dy := -3; dy <= 3; dy++ {
				ok := true
				for i := 0; i < 4; i++ {
					for j := 0; j < 4; j++ {
						if p[k][i][j] == "." {
							continue
						}
						nx := i + dx
						ny := j + dy
						if nx < 0 || ny < 0 || nx > 3 || ny > 3 {
							ok = false
							continue
						}

					}
				}
				if ok {
					m := [][]string{{".", ".", ".", "."}, {".", ".", ".", "."}, {".", ".", ".", "."}, {".", ".", ".", "."}}
					for i := 0; i < 4; i++ {
						for j := 0; j < 4; j++ {
							if p[k][i][j] == "." {
								continue
							}
							nx := i + dx
							ny := j + dy
							m[nx][ny] = "#"
						}
					}
					result[k] = append(result[k], m)
				}
			}
		}
	}

	return result
}

func rotate(input [][]string) {
	copied := deepCopy(input)
	for i := 0; i < 4; i++ {
		for j := 0; j < 4; j++ {
			input[j][3-i] = copied[i][j]
		}
	}
}

func deepCopy(input [][]string) [][]string {
	result := make([][]string, 4)
	for i := 0; i < 4; i++ {
		result[i] = make([]string, 4)
		copy(result[i], input[i])
	}
	return result
}
