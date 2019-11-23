package model;

import main.ChessBoard;
import main.Player;

public class Queen extends ChessPiece {

    public Queen (Player.Color color, int startX, int startY) {
        super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(ChessBoard b, int x, int y) {
        return (this.getX() == x || this.getY() == y ||
        this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    public int getNumPoints() {
        return 9;
    }

    public String getName() {
        return "Queen";
    } // "King", "Queen", "Pawn", etc.
}
