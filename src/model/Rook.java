package model;

public class Rook extends ChessPiece {

  public boolean getCanMoveToPosition(int x, int y)
  {
    return (this.getX() == x || this.getY() == y) ? true : false;
  };
  public int getNumPoints()
  {
    return 5;
  };
  public String getName()
  {
    return "Rook";
  }; // "King", "Queen", "Pawn", etc.
}
