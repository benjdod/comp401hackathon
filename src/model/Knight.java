package model;

import main.ChessBoard;
import main.ChessSpot;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        ArrayList<Move> possibleMoves = getAllPossibleMoves();

        Move moveCheck = new Move(this.getPlayer(), this.getX(), this.getY(), x, y);

        boolean isPossibleMove = false;
        for(int i = 0; i < possibleMoves.size(); i++) {
            if(possibleMoves.get(i).equals(moveCheck)) {
                isPossibleMove = true;
            }
        }
        return isPossibleMove;
    }

    public ArrayList<Move> getAllPossibleMoves() {

        ArrayList <Move> allPossibleMoves = new ArrayList<Move>();

        for (ChessSpot s : _board) {

            boolean isKnightMove = false;

            if ((Math.abs(this.getX() - s.getSpotXCoord()) == 2 && Math.abs(this.getY() - s.getSpotYCoord()) == 1)
                  || ((Math.abs(this.getX() - s.getSpotXCoord())) == 1 && Math.abs(this.getY() - s.getSpotYCoord()) == 2)) {
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
