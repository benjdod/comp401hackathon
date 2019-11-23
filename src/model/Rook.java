package model;

import main.*;

public class Rook extends ChessPiece {

    public Rook (ChessBoard board, Player.Color color, int startX, int startY) {
        super(board, color, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() == x || this.getY() == y) ? true : false;
    }

    @Override
    public Move getAllPossibleMoves() {
        return null; // TODO add this
    }

    public int getNumPoints() {
        return 5;
    }

    public String getName() {
        return "Rook";
    }
}
