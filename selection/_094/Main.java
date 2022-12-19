package selection._094;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int d = sc.nextInt();
            if (n == 0 && w == 0 && d == 0) {
                break;
            }
            long[] p = new long[n];
            long[] s = new long[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextLong();
                s[i] = sc.nextLong();
            }

            List<Piece> pieces = new ArrayList<>();
            pieces.add(new Piece(1, w, d));

            for (int i = 0; i < n; i++) {
                Piece piece = filterById(pieces, p[i]);
                Piece[] cutted = cut(piece, i + 1, s[i]);
                adjust(pieces, cutted, p[i]);
            }

            Collections.sort(pieces, new Comparator<Piece>() {
                @Override
                public int compare(Piece o1, Piece o2) {
                    return (int) (o1.h * o1.w - o2.h * o2.w);
                }
            });
            StringBuilder builder = new StringBuilder();
            for (Piece piece : pieces) {
                builder.append(piece.h * piece.w).append(" ");
            }

            out.println(builder.toString().trim());
        }

        out.flush();
        sc.close();
    }

    static void adjust(List<Piece> pieces, Piece[] cutted, long id) {
        Piece p = filterById(pieces, id);
        p.id = cutted[0].id;
        p.h = cutted[0].h;
        p.w = cutted[0].w;
        pieces.add(cutted[1]);

        Collections.sort(pieces, new Comparator<Piece>() {
            @Override
            public int compare(Piece o1, Piece o2) {
                return (int) (o1.id - o2.id);
            }
        });
        long pieceId = 1;
        for (Piece piece : pieces) {
            piece.id = pieceId;
            pieceId++;
        }
    }

    static Piece[] cut(Piece piece, long num, long move) {
        Piece[] cutted = new Piece[2];
        move %= 2 * (piece.w + piece.h);

        // firstのほうがsecondより大きさが小さい
        Piece first, second;
        long small, big;
        if (0 < move && move < piece.w) {
            small = Math.min(move, piece.w - move);
            big = Math.max(move, piece.w - move);
            first = new Piece(num + 1, small, piece.h);
            second = new Piece(num + 2, big, piece.h);
        } else if (piece.w < move && move < piece.w + piece.h) {
            small = Math.min(move - piece.w, piece.h - (move - piece.w));
            big = Math.max(move - piece.w, piece.h - (move - piece.w));
            first = new Piece(num + 1, piece.w, small);
            second = new Piece(num + 2, piece.w, big);
        } else if (piece.w + piece.h < move && move < 2 * piece.w + piece.h) {
            small = Math.min(2 * piece.w + piece.h - move, piece.w - (2 * piece.w + piece.h - move));
            big = Math.max(2 * piece.w + piece.h - move, piece.w - (2 * piece.w + piece.h - move));
            first = new Piece(num + 1, small, piece.h);
            second = new Piece(num + 2, big, piece.h);
        } else {
            small = Math.min(2 * piece.w + 2 * piece.h - move, piece.h - (2 * piece.w + 2 * piece.h - move));
            big = Math.max(2 * piece.w + 2 * piece.h - move, piece.h - (2 * piece.w + 2 * piece.h - move));
            first = new Piece(num + 1, piece.w, small);
            second = new Piece(num + 2, piece.w, big);
        }

        cutted[0] = first;
        cutted[1] = second;

        return cutted;
    }

    static Piece filterById(List<Piece> pieces, long id) {
        for (Piece piece : pieces) {
            if (piece.id == id) {
                return piece;
            }
        }
        System.err.println("ピースが見つかりませんでした。");
        return null;
    }
}

class Piece {
    long id;
    long w, h;

    Piece(long id, long w, long h) {
        this.id = id;
        this.w = w;
        this.h = h;
    }
}