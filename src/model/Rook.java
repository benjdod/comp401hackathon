package model;

import main.*;

import java.util.ArrayList;

public class Rook extends ChessPiece {

    public Rook (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() == x || this.getY() == y) ? true : false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        return null; // TODO add this
    }

    public int getNumPoints() {
        return 5;
    }

    public String getName() {
        return "Rook";
    }
}
