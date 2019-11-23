package model;

import main.ChessBoard;
import main.Player;

public class Pawn extends ChessPiece {

    public Pawn (Player.Color color, int startX, int startY) {
        super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(ChessBoard b, int x, int y) {
        if (this.getPlayer() == Player.Color.WHITE && y - this.getY() == 1 && x == this.getX()) {
            return true;
        } else if (this.getPlayer() == Player.Color.BLACK && y - this.getY() == -1 && x == this.getX()) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumPoints() {
        return 1;
    }

    public String getName() {
        return "Pawn";
    }
}
