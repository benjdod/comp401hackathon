package model;

import main.ChessBoard;
import main.Move;
import main.Player;

public class Pawn extends ChessPiece {

    public Pawn (ChessBoard board, Player.Color color, int startX, int startY) {
        super(board, color, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        if (this.getPlayer() == Player.Color.WHITE && y - this.getY() == 1 && x == this.getX()) {
            return true;
        } else if (this.getPlayer() == Player.Color.BLACK && y - this.getY() == -1 && x == this.getX()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Move getAllPossibleMoves() {
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
