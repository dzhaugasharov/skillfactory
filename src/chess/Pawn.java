package chess;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || column != toColumn) {
            return false;
        }
        ChessPiece targetChessPiece = chessBoard.board[toLine][toColumn];
        // target point is busy by teammate
        if (targetChessPiece != null && color.equals(targetChessPiece.getColor())) {
            return false;
        }

        if (color.equals("White")) {
            if (line >= toLine) return false;
            if (line == 1 && toLine == 3) return true;
            if (toLine - line > 1) return false;
        }
        else {
            if (line <= toLine) return false;
            if (line == 6 && toLine == 4) return true;
            if (line - toLine > 1) return false;
        }
        return true;
    }

    public String getSymbol() {
        return "P";
    }
}
