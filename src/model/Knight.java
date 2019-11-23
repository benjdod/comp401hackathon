package model;

import main.ChessSpot;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight (Player.Color color, int startX, int startY) {
      super(color, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        ArrayList<Move> possibleMoves = getAllPossibleMoves(_board);

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

    public ArrayList<Move> getAllPossibleMoves() {

        ArrayList <Move> allPossibleMoves = new ArrayList<Move>();

        for(ChessSpot s : _board) {

            boolean isKnightMove = false;

            if ((Math.abs(this.getX() - _x) == 2 && Math.abs(this.getY() - _y) == 1)
                  || (Math.abs(this.getX() - _x) == 1 && Math.abs(this.getY() - _y) == 2)) {
                isKnightMove = true;
            }

            if (isKnightMove && s.isEmpty()) {
                allPossibleMoves.add(new Move(this.getPlayer(), this.getX(), this.getY(), s.getSpotX(), s.getSpotY()));
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
