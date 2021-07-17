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
        if (line == toLine && Math.abs(column - toColumn) == 1) canMove = true;
        if (column == toColumn && Math.abs(line - toLine) == 1) canMove = true;

        // diagonal
        if (Math.abs(column - toColumn) == 1 && Math.abs(column - toColumn) == Math.abs(line - toLine)) canMove = true;

        if (canMove) check = false;

        return canMove;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {

        // right
        for (int n = column + 1; n <= 7; n++) {
            if (board.board[line][n] != null) {
                ChessPiece cp = board.board[line][n];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("R")) return true;
                break;
            }
        }

        // left
        for (int n = column - 1; n >= 0; n--) {
            if (board.board[line][n] != null) {
                ChessPiece cp = board.board[line][n];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("R")) return true;
                break;
            }
        }

        // up
        for (int n = line + 1; n <= 7; n++) {
            if (board.board[n][column] != null) {
                ChessPiece cp = board.board[n][column];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("R")) return true;
                break;
            }
        }

        // down
        for (int n = line - 1; n >= 0; n--) {
            if (board.board[n][column] != null) {
                ChessPiece cp = board.board[n][column];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("R")) return true;
                break;
            }
        }

        // diagonal
        // top right
        int col = column;
        for (int l = line + 1; l <= 7; l ++) {
            col++;
            if (col > 7) break;
            if (board.board[l][col] != null) {
                ChessPiece cp = board.board[l][col];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("B")) return true;
                break;
            }
        }

        // top left
        col = column;
        for (int l = line + 1; l <= 7; l ++) {
            col--;
            if (col < 0) break;
            if (board.board[l][col] != null) {
                ChessPiece cp = board.board[l][col];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("B")) return true;
                break;
            }
        }

        // bottom left
        col = column;
        for (int l = line - 1; l >= 0; l--) {
            col--;
            if (col < 0) break;

            if (board.board[l][col] != null) {
                ChessPiece cp = board.board[l][col];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("B")) return true;
                break;
            }
        }

        // bottom right
        col = column;
        for (int l = line - 1; l >= 0; l--) {
            col++;
            if (col > 7) break;

            if (board.board[l][col] != null) {
                ChessPiece cp = board.board[l][col];
                String symbol = cp.getSymbol();
                if (color.equals(cp.color)) break;
                else if (symbol.equals("Q") || symbol.equals("B")) return true;
                break;
            }
        }

        // HORSE
        // i--
        if (column <= 5 && line <= 6) {
            ChessPiece cp = board.board[line + 1][column + 2];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // |__
        if (column <= 5 && line >= 1) {
            ChessPiece cp = board.board[line - 1][column + 2];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // --i
        if (column >= 2 && line <= 6) {
            ChessPiece cp = board.board[line + 1][column - 2];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // __|
        if (column >= 2 && line >= 1) {
            ChessPiece cp = board.board[line - 1][column - 2];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // L
        if (column >= 1 && line <= 5) {
            ChessPiece cp = board.board[line + 2][column - 1];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // L>
        if (column <= 6 && line <= 5) {
            ChessPiece cp = board.board[line + 2][column + 1];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // ^L
        if (column >= 1 && line >= 2) {
            ChessPiece cp = board.board[line - 2][column - 1];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        // ^>L
        if (column <= 6 && line >= 2) {
            ChessPiece cp = board.board[line - 2][column + 1];
            if (cp != null && !cp.color.equals(color) && cp.getSymbol().equals("H")) return true;
        }

        return false;
    }

}
