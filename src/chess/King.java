package chess;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
        check = true;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0 || (line == toLine && column == toColumn)) {
            return false;
        }
        boolean canMove = false;

        ChessPiece targetChessPiece = chessBoard.board[toLine][toColumn];
        // target point is busy by teammate
        if (targetChessPiece != null && color.equals(targetChessPiece.getColor())) {
            return false;
        }

        // straight
        if (line == toLine && column != toColumn && Math.abs(column - toColumn) == 1) canMove = true;
        if (column == toColumn && line != toLine && Math.abs(line - toLine) == 1) canMove = true;

        // diagonal
        if (Math.abs(column - toColumn) == 1 && Math.abs(column - toColumn) == Math.abs(line - toLine)) canMove = true;

        if (canMove) check = false;

        return canMove;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        return false;
    }

}
