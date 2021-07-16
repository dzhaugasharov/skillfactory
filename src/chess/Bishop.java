package chess;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0 || column == toColumn || line == toLine) {
            return false;
        }
        ChessPiece targetChessPiece = chessBoard.board[toLine][toColumn];

        // target point is busy by teammate
        if (targetChessPiece != null && color.equals(targetChessPiece.getColor())) {
            return false;
        }

        if (Math.abs(column - toColumn) != Math.abs(line - toLine)) {
            return false;
        }
        int lineStep = toLine > line ? 1 : -1;
        int colStep = toColumn > column ? 1 : -1;
        for (int l = line + 1; l < toLine; l += lineStep) {
            for (int c = line + 1; c < toColumn; c += colStep) {
                if (chessBoard.board[l][c] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    public String getSymbol() {
        return "B";
    }
}