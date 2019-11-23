package model;

import main.ChessBoard;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        if (getPlayer().getColor() == Player.Color.WHITE && y - this.getY() == 1 && x == this.getX()) {
            return true;
        } else if (getPlayer().getColor() == Player.Color.BLACK && y - this.getY() == -1 && x == this.getX()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        return null; // TODO add this
    }

    @Override
    public int getNumPoints() {
        return 1;
    }

    @Override
    public String getName() {
        return "Pawn";
    }
}
