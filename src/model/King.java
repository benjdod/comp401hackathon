package model;

import main.ChessBoard;
import main.Player;

public class King extends ChessPiece {
    public King (ChessBoard board, Player.Color color, int startX, int startY) {
        super(board, color, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        if(Math.abs(this.getX() - x) <= 1 || Math.abs(this.getY() - y) <= 1)
        {
          ChessSpot s = board.getSpotAt(x, y);
          if(s.isEmpty() || !s.getPieceColor().equals(this.color))
          {
            return true;
          }
          else
          {
            return false;
          }
        }
        else
        {
          return false;
        }
    }

    @Override
    public int getNumPoints() {
      return 0;
    }

    @Override
    public String getName() {
        return "King";
    }
}
