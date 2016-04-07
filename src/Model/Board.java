package Model;

public class Board {
    private static final int defaultsize = 10;
    private StringBuffer[][] data;
    private int w;
    private int h;

    public Board() {
        w = defaultsize;
        h = defaultsize;
        data = new StringBuffer[h][w];
        for( int y = 0; y < h; ++ y ){
            for( int x = 0; x < w; ++ x ){
                data[y][x] = new StringBuffer("");
            }
        }
    }

    public Board(int _w, int _h) {
        w = _w;
        h = _h;
        data = new StringBuffer[h][w];
        for( int y = 0; y < h; ++ y ){
            for( int x = 0; x < w; ++ x ){
                data[y][x] = new StringBuffer("");
            }
        }
    }

    public int GetW() {
        return w;
    }

    public int GetH() {
        return h;
    }

    public StringBuffer GetEl(int _h, int _w) {
        return data[_h][_w];
    }

    public void SetEl(char c, int _h, int _w) {
        data[_h][_w].append(c);
    }

    public void DelEl(char c, int _h, int _w) {
        for (int i = 0; i < data[_h][_w].length(); i++) {
            if (data[_h][_w].charAt(i) == c) {
                data[_h][_w].deleteCharAt(i);
                break;
            }
        }
    }

    public void PrintBoard() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (data[j][i].length() > 0)
                    System.out.print(data[j][i].charAt(0));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (data[i][j].length() > 0)
                    return false;
            }
        }
        return true;
    }
}