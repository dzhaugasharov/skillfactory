package chess;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
        check = true;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0) {
            return false;
        }
        if (line == toLine && column != toColumn || column == toColumn && line != toLine) {
            check = false;
            return true;
        }
        return false;
    }

    public String getSymbol() {
        return "R";
    }
}
