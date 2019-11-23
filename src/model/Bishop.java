package model;

import main.*;

public class Bishop extends ChessPiece {

    public Bishop (ChessBoard board, Player.Color color, int startX, int startY) {
        super(board, color, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    @Override
    public int getNumPoints() {
        return 3;
    }

    @Override
    public String getName() {
        return "Bishop";
    }
}
