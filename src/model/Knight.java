package model;

public class Knight extends ChessPiece {

  public boolean getCanMoveToPosition(int x, int y)
  {
    return ((Math.abs(this.getX() - x) == 2 && Math.abs(this.getY() - y) == 1)
    || (Math.abs(this.getX() - x) == 1 && Math.abs(this.getY() - y) == 2)) ? true : false;
  };
  public int getNumPoints()
  {
    return 3;
  };
  public String getName()
  {
    return "Knight";
  };
}
