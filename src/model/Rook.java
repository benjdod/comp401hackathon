package model;

import main.ChessBoard;
import main.Move;
import main.Player;

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
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        possibleMoves.addAll(getLineMovesInDirection(1,0));
        possibleMoves.addAll(getLineMovesInDirection(0,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,0));
        possibleMoves.addAll(getLineMovesInDirection(0,-1));
        return possibleMoves;
    }

    public int getNumPoints() {
        return 5;
    }

    public String getName() {
        return "Rook";
    }
}
