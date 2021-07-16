package chess;

public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0 || (line == toLine && column == toColumn)) {
            return false;
        }
        // straight
        if (line == toLine && column != toColumn) return true;
        if (column == toColumn && line != toLine) return true;

        // diagonal
        if (Math.abs(column - toColumn) == Math.abs(line - toLine)) return true;

        return false;
    }

    public String getSymbol() {
        return "Q";
    }

}
