package chess;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 8 || toLine < 0 || toColumn > 8 || toColumn < 0 || toLine == line || column == toColumn) {
            return false;
        }
        // right or left
        if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) {
            return true;
        }
        // up or down
        else if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2) {
            return true;
        }
        return false;
    }

    public String getSymbol() {
        return "H";
    }
}
