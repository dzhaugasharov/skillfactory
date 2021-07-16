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
        ChessPiece targetChessPiece = chessBoard.board[toLine][toColumn];
        // target point is busy by teammate
        if (targetChessPiece != null && color.equals(targetChessPiece.getColor())) {
            return false;
        }
        int lineStep = toLine > line ? 1 : -1;
        int colStep = toColumn > column ? 1 : -1;

        // straight
        if (line == toLine && column != toColumn) {
            // checking the way
            for (int n = column + 1; n < toColumn; n += colStep) {
                if (chessBoard.board[toLine][n] != null) return false;
            }

            return true;
        }
        if (column == toColumn && line != toLine) {
            // checking the way
            for (int n = line + 1; n < toLine; n += lineStep) {
                if (chessBoard.board[n][column] != null) return false;
            }

            return true;
        }

        // diagonal
        if (Math.abs(column - toColumn) == Math.abs(line - toLine)) {
            // checking the way

            for (int l = line + 1; l < toLine; l += lineStep) {
                for (int c = line + 1; c < toColumn; c += colStep) {
                    if (chessBoard.board[l][c] != null) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }

    public String getSymbol() {
        return "Q";
    }

}
