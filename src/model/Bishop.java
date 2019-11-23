package model;

import main.*;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

    public Bishop (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return getX() + getY() == x + y || this.getY() - this.getX() == y - x;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        possibleMoves.addAll(getLineMovesInDirection(1,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,-1));
        possibleMoves.addAll(getLineMovesInDirection(1,-1));
        return possibleMoves;
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
