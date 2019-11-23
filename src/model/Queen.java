package model;

import main.ChessBoard;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Queen extends ChessPiece {

    public Queen (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() == x || this.getY() == y ||
        this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        possibleMoves.addAll(getLineMovesInDirection(1,0));
        possibleMoves.addAll(getLineMovesInDirection(0,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,0));
        possibleMoves.addAll(getLineMovesInDirection(0,-1));
        possibleMoves.addAll(getLineMovesInDirection(1,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,-1));
        possibleMoves.addAll(getLineMovesInDirection(1,-1));
        return possibleMoves;
    }

    @Override
    public int getNumPoints() {
        return 9;
    }

    @Override
    public String getName() {
        return "Queen";
    } // "King", "Queen", "Pawn", etc.
}
