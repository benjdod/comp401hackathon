package main;
import java.util.Random;

public class AIPlayer implements Player {

  private Player.Color _color;

  public AIPlayer(Color color)
  {
    this._color = color;
  }

  public Move checkForMoves(ChessBoard cb, int x, int y)
  {
    ArrayList<Move> eligibleMoves = new ArrayList<Move>();
    for(ChessSpot s : cb)
    {
      if(s.getPiece() != null && s.getPieceColor().equals(_color))
      {
        ChessPiece p = s.getPiece();
        for(ChessSpot s : cb)
        {
          if(p.getCanMoveToPosition(x, y))
          {
            eligibleMoves.add(new Move(this, s.getPiece().getX(), s.getPiece().getY(), x, y));
          }
        }
      }
    }

    Random r = new Random();
    int moveToSelect = r.nextInt(0, eligibleMoves.size()-1);

    if(eligibleMoves.size > 0)
    {
      return eligibleMoves.get(moveToSelect);
    }
    else
    {
      return null;
    }
  }
}
