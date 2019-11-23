package model;

public class Bishop extends ChessPiece {

  public boolean getCanMoveToPosition(int x, int y)
  {
    return (this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
  };
  public int getNumPoints()
  {
    return 3;
  };
  public String getName()
  {
    return "Bishop";
  }; // "King", "Queen", "Pawn", etc.
}
