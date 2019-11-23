package model;

import main.ChessBoard;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Queen extends ChessPiece {

    public Queen (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() == x || this.getY() == y ||
        this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        possibleMoves.addAll(getAllMovesInDirection(1,0));
        possibleMoves.addAll(getAllMovesInDirection(0,1));
        possibleMoves.addAll(getAllMovesInDirection(-1,0));
        possibleMoves.addAll(getAllMovesInDirection(0,-1));
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
        return 9;
    }

    @Override
    public String getName() {
        return "Queen";
    } // "King", "Queen", "Pawn", etc.
}
