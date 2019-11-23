package model;

import main.*;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

    public Bishop (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        return null; // TODO write this
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
