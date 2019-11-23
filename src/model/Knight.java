package model;

import main.Player;

public class Knight extends ChessPiece {

    public Knight (Player.Color color, int startX, int startY) {
      super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        ArrayList<Move> possibleMoves = getAllPossibleMoves(cb);
        Move moveCheck = new Move(this.getPlayer(), this.getX(), this.getY(), x, y);
        boolean isPossibleMove = false;
        for(int i = 0; i < possibleMoves.size(); i++)
        {
          if(possibleMoves.get(i).equals(moveCheck))
          {
            isPossibleMove = true;
          }
        }
        return isPossibleMove;
    }

    public ArrayList<Move> getAllPossibleMoves(ChessBoard cb)
    {
      ArrayList <Move> allPossibleMoves = new ArrayList<Move>();
      for(ChessSpot s: cb)
      {
        boolean isKnightMove = false;
        if((Math.abs(this.getX() - x) == 2 && Math.abs(this.getY() - y) == 1)
        || (Math.abs(this.getX() - x) == 1 && Math.abs(this.getY() - y) == 2))
        {
          isKnightMove = true;
        }

        if(isKnightMove)
        {
          if s.isEmpty()
          {
            allPossibleMoves.add(new Move(this.getPlayer(), this.getX(), this.getY(), s.getSpotX(), s.getSpotY()));
          }
        }
      }
      return allPossibleMoves;
    }

    public int getNumPoints() {
        return 3;
    }

    public String getName() {
      return "Knight";
    }
}
