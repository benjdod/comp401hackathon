package main;
import model.ChessPiece;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer implements Player {

    private Player.Color _color;

    public AIPlayer(Color color)
  {
    this._color = color;
  }

    public Move getRandomMoveFrom(ChessBoard board, int x, int y) {
      ArrayList<Move> eligibleMoves = new ArrayList<Move>();

      for (ChessSpot s : board) {
          if (s.getPiece() != null && s.getPiece().getPlayer().getColor().equals(_color)) {
              ChessPiece p = s.getPiece();
              if (p.getCanMoveToPosition(x, y)) {
                  eligibleMoves.add(new Move(this, s.getPiece().getX(), s.getPiece().getY(), x, y));
              }
          }
      }

        Random r = new Random();
        int moveToSelect = r.nextInt(eligibleMoves.size()-1);

        return (eligibleMoves.size() > 0) ? eligibleMoves.get(moveToSelect) : null;
    }

  @Override
  public Move getNextMove(ChessBoard board) {
    return null; // FIXME make this smarter
  }

  @Override
  public Color getColor() {
    return _color;
  }
}
