package model;

public class Rook extends ChessPiece {

  public boolean getCanMoveToPosition(int x, int y);
  public int getNumPoints();
  public String getName()
  {
    return "Rook";
  }; // "King", "Queen", "Pawn", etc.
  public String getPieceColor();
}
