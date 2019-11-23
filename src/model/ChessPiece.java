package model;

public abstract class ChessPiece {
    private int x;
    private int y;
    private Player p;

    private enum Player {BLACK, WHITE};

    private ChessPiece(Player player)
    {
      if (player == Player.WHITE)
      {
        p = Player.WHITE;
      }
      else
      {
        p = Player.BLACK;
      }
    }

    public abstract getX()
    {
      return x;
    }
    public abstract getY()
    {
      return y;
    }

    public abstract boolean getCanMoveToPosition(int x, int y);
    public abstract int getNumPoints();
    public abstract String getName(); // "King", "Queen", "Pawn", etc.
    public abstract String getPieceColor()
    {
      if p == Player.WHITE()
      {
        return "white";
      }
      else
      {
        return "black";
      }
    }
    public abstract Player getPlayer()
    {
      return p;
    }
  }
