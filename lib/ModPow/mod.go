package modpow

func ModPow(a, b, p uint64) uint64 {
	var ret uint64 = 1
	for b > 0 {
		if b&1 == 1 {
			ret = ret * a % p
		}
		a = a * a % p
		b >>= 1
	}

	return ret
}
