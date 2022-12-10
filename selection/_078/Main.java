package selection._078;

import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Stringからcharに変えるだけでパフォーマンス&メモリ改善
        char[][] s = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                s[i][j] = line.charAt(j);
            }
        }

        // 累積和（頂点(0,0)から頂点(m-1,n-1)までの領域に含まれる個数）
        int[][] jungleSum = new int[m + 1][n + 1];
        int[][] oceanSum = new int[m + 1][n + 1];
        int[][] iceSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1][j - 1] == 'J') {
                    jungleSum[i][j] = jungleSum[i][j - 1] + jungleSum[i - 1][j] - jungleSum[i - 1][j - 1] + 1;
                    oceanSum[i][j] = oceanSum[i][j - 1] + oceanSum[i - 1][j] - oceanSum[i - 1][j - 1];
                    iceSum[i][j] = iceSum[i][j - 1] + iceSum[i - 1][j] - iceSum[i - 1][j - 1];
                } else if (s[i - 1][j - 1] == 'O') {
                    jungleSum[i][j] = jungleSum[i][j - 1] + jungleSum[i - 1][j] - jungleSum[i - 1][j - 1];
                    oceanSum[i][j] = oceanSum[i][j - 1] + oceanSum[i - 1][j] - oceanSum[i - 1][j - 1] + 1;
                    iceSum[i][j] = iceSum[i][j - 1] + iceSum[i - 1][j] - iceSum[i - 1][j - 1];
                } else {
                    jungleSum[i][j] = jungleSum[i][j - 1] + jungleSum[i - 1][j] - jungleSum[i - 1][j - 1];
                    oceanSum[i][j] = oceanSum[i][j - 1] + oceanSum[i - 1][j] - oceanSum[i - 1][j - 1];
                    iceSum[i][j] = iceSum[i][j - 1] + iceSum[i - 1][j] - iceSum[i - 1][j - 1] + 1;
                }
            }
        }

        // StringBuilderもパフォーマンス改善に貢献
        StringBuilder builder = new StringBuilder();
        int a, b, c, d, jungleCount, oceanCount, iceCount;
        for (int i = 0; i < k; i++) {
            // 左上の頂点はそのまま区画の位置に対応する
            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;
            // 右下の頂点は区画の位置の右下に対応する
            c = sc.nextInt();
            d = sc.nextInt();

            jungleCount = jungleSum[c][d] - jungleSum[c][b] - jungleSum[a][d] + jungleSum[a][b];
            oceanCount = oceanSum[c][d] - oceanSum[c][b] - oceanSum[a][d] + oceanSum[a][b];
            iceCount = iceSum[c][d] - iceSum[c][b] - iceSum[a][d] + iceSum[a][b];

            builder.append(jungleCount).append(" ").append(oceanCount).append(" ").append(iceCount).append("\n");
        }

        System.out.print(builder);
    }
}

class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        } else {
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() {
        if (hasNextByte())
            return buffer[ptr++];
        else
            return -1;
    }

    private static boolean isPrintableChar(int c) {
        return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrintableChar(buffer[ptr]))
            ptr++;
        return hasNextByte();
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        if (!hasNext())
            throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while (true) {
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            } else if (b == -1 || !isPrintableChar(b)) {
                return minus ? -n : n;
            } else {
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }

    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
            throw new NumberFormatException();
        return (int) nl;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
