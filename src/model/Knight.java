package model;

import main.ChessBoard;
import main.ChessSpot;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        if (_board.getSpotAt(x,y).getPiece() == null) {
            return getIsKnightMove(new Move(getPlayer(), getX(), getY(), x, y));
        }
        if (_board.getSpotAt(x, y).getPiece().getPlayer() != getPlayer()) {
            return getIsKnightMove(new Move(getPlayer(), getX(), getY(), x, y));
        }
        return false;
    }

    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList <Move> allPossibleMoves = new ArrayList<>();

        for (ChessSpot s : _board) {
            Move thisMove = new Move(getPlayer(), getX(), getY(), s.getSpotX(), s.getSpotY());
            if (!getIsKnightMove(thisMove)) {
                continue;
            }

            if (s.isEmpty() || s.getPiece().getPlayer().getColor() != getPlayer().getColor()) {
                allPossibleMoves.add(thisMove);
            }
        }

        if (allPossibleMoves.size() == 0) {
            return null;
        }
        return allPossibleMoves;
    }

    private boolean getIsKnightMove(Move m) {
        int dy = Math.abs(m.getStartY()-m.getEndY());
        int dx = Math.abs(m.getStartX()-m.getEndX());
        return (dy == 2 && dx == 1) || (dy == 1 && dx == 2);
    }

    public int getNumPoints() {
        return 3;
    }

    public String getName() {
      return "Knight";
    }
}
