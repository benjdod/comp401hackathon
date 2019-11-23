package model;

import main.ChessBoard;
import main.Player;

public class King extends ChessPiece {
    public King (Player.Color color, int startX, int startY) {
        super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(ChessBoard b, int x, int y) {
        return (Math.abs(this.getX() - x) <= 1 || Math.abs(this.getY() - y) <= 1) ? true : false;
    }

    public int getNumPoints() {
      return 0;
    }

    public String getName() {
        return "King";
    }
}
