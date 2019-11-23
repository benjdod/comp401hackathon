package model;

import main.*;

import java.util.ArrayList;

public class Bishop extends ChessPiece {

    public Bishop (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        possibleMoves.addAll(getAllMovesInDirection(1,1));
        possibleMoves.addAll(getAllMovesInDirection(-1,1));
        possibleMoves.addAll(getAllMovesInDirection(-1,-1));
        possibleMoves.addAll(getAllMovesInDirection(1,-1));
        return possibleMoves;
    }


    public ArrayList<Move> getAllMovesInDirection(int dx, int dy)
    {
      ArrayList<Move> output = new ArrayList<Move>();
      cx = this.getX();
      cy = this.getY();
      for (int x = 0; x < 8; x++)
      {
        cx += dx;
        cy += dy;
        if(cx >= 8 || cy >= 8 || cx < 0 || cy < 0)
        {
          break;
        }
        if(!board.getSpotAt(cx, cy).isEmpty())
        {
          if(board.getSpotAt(cx, cy).getPieceColor().equals(this.color))
          {
            break;
          }
          else
          {
            output.add(new Move(this, this.getX(), this.getY(), cx, cy));
            break;
          }
        }
        else
        {
          output.add(new Move(this, this.getX(), this.getY(), cx, cy));
          continue;
        }
      }

      return output;
    }

    @Override
    public int getNumPoints() {
        return 3;
    }

    @Override
    public String getName() {
        return "Bishop";
    }
}
