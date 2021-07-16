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
        ChessPiece targetChessPiece = chessBoard.board[toLine][toColumn];
        // target point is busy by teammate
        if (targetChessPiece != null && color.equals(targetChessPiece.getColor())) {
            return false;
        }

        int lineStep = toLine > line ? 1 : -1;
        int colStep = toColumn > column ? 1 : -1;
        if (line == toLine && column != toColumn) {
            // checking the way
            for (int n = column + 1; n < toColumn; n += colStep) {
                if (chessBoard.board[toLine][n] != null) return false;
            }
        }
        if (column == toColumn && line != toLine) {
            // checking the way
            for (int n = line + 1; n < toLine; n += lineStep) {
                if (chessBoard.board[n][column] != null) return false;
            }
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
