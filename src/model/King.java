package model;

public class King extends ChessPiece {



    public boolean getCanMoveToPosition(int x, int y) {
        return (Math.abs(this.getX() - x) <= 1 || Math.abs(this.getY() - y) <= 1) ? true : false;
    }
    public int getNumPoints() {
      return 0;
    }

    public String getName() {
        return "King";
    }
}
