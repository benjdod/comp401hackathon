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
        if(Math.abs(this.getX() - x) <= 1 && Math.abs(this.getY() - y) <= 1) {
            ChessSpot s = _board.getSpotAt(x, y);
            return s.isEmpty() || !s.getPiece().getPlayer().getColor().equals(_player.getColor());
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> output = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            try {
                int thisX = getX();
                int thisY = getY();
                thisX += (i > 0 && i < 5) ? 1 : (i > 5) ? -1 : 0;
                thisY += (i > 2 && i < 6) ? -1 : (i == 2 || i == 6) ? 0 : 1;
                if (getCanMoveToPosition(thisX, thisY)) {
                    Move temp = new Move(getPlayer(), getX(), getY(), thisX, thisY);
                    output.add(temp);
                }
            } catch (Exception e) {}
        }
        return output;
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
