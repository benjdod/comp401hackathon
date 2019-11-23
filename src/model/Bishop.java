package model;

import main.*;

public class Bishop extends ChessPiece {

    public Bishop (Player.Color color, int startX, int startY) {
        super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(ChessBoard b, int x, int y) {
        return (this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    public int getNumPoints() {
        return 3;
    }

    public String getName() {
        return "Bishop";
    }
}
