package model;

import main.ChessBoard;
import main.Player;

public class Queen extends ChessPiece {

    public Queen (ChessBoard board, Player.Color color, int startX, int startY) {
        super(board, color, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() == x || this.getY() == y ||
        this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    @Override
    public int getNumPoints() {
        return 9;
    }

    @Override
    public String getName() {
        return "Queen";
    } // "King", "Queen", "Pawn", etc.
}
