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
        ChessPiece chessPiece = chessBoard.board[line][column];
        ChessPiece targetChessPiece = chessBoard.board[toLine][toColumn];

        if (targetChessPiece != null && chessPiece.getColor().equals(targetChessPiece.getColor())) {
            return false;
        }

        return Math.abs(column - toColumn) == Math.abs(line - toLine);
    }

    public String getSymbol() {
        return "B";
    }
}