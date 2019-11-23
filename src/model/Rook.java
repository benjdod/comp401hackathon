package model;

import main.*;

public class Rook extends ChessPiece {

    public Rook (Player.Color color, int startX, int startY) {
        super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(ChessBoard b, int x, int y) {
        return (this.getX() == x || this.getY() == y) ? true : false;
    }

    public int getNumPoints() {
        return 5;
    }

    public String getName() {
        return "Rook";
    }
}
