package model;

public class Pawn extends ChessPiece {

  public boolean getCanMoveToPosition(int x, int y)
  {
    if (this.getPlayer() == Player.WHITE && y - this.getY() == 1 && x == this.getX())
    {
      return true;
    }
    else if (this.getPlayer() == Player.BLACK && y - this.getY() == -1 && x == this.getX())
    {
      return true;
    }
    else
    {
      return false;
    }
  };
  public int getNumPoints()
  {
    return 1;
  };
  public String getName()
  {
    return "Pawn";
  };
}
