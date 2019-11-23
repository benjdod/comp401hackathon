package model;

import main.ChessBoard;
import main.ChessSpot;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class King extends ChessPiece {
    public King (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
<<<<<<< HEAD
        if(Math.abs(this.getSpotX() - x) <= 1 || Math.abs(this.getY() - y) <= 1) {
            ChessSpot s = _board.getSpotAt(x, y);
            return s.isEmpty() || !s.getPiece().getPlayer().getColor().equals(_player.getColor());
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        return null; // FIXME write this
    }

    @Override
    public int getNumPoints() {
      return 1000;
    }

    @Override
    public String getName() {
        return "King";
    }
}
