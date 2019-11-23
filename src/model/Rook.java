package model;

import main.ChessBoard;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Rook extends ChessPiece {

    public Rook (ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getSpotX() == x || this.getY() == y) ? true : false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<Move>();
        possibleMoves.addAll(getLineMovesInDirection(1,0));
        possibleMoves.addAll(getLineMovesInDirection(0,1));
        possibleMoves.addAll(getLineMovesInDirection(-1,0));
        possibleMoves.addAll(getLineMovesInDirection(0,-1));
        return possibleMoves;
    }

<<<<<<< HEAD

    public ArrayList<Move> getAllMovesInDirection(int dx, int dy) {
        ArrayList<Move> output = new ArrayList<Move>();
        int cx = this.getSpotX();
        int cy = this.getY();
        for (int x = 0; x < 8; x++) {
            cx += dx;
            cy += dy;
            if(cx >= 8 || cy >= 8 || cx < 0 || cy < 0) {
                break;
            }
            if (!_board.getSpotAt(cx, cy).isEmpty()) {
                if (_board.getSpotAt(cx, cy).getPiece().getPieceColor() == getPieceColor()) {
                    break;
                } else {
                    output.add(new Move(getPlayer(), this.getSpotX(), this.getY(), cx, cy));
                    break;
                }
            } else {
                output.add(new Move(getPlayer(), this.getSpotX(), this.getY(), cx, cy));
                continue;
            }
        }
        return output;
    }

=======
>>>>>>> fc9a420ff2450cd413499bc9e215344b358573a6
    public int getNumPoints() {
        return 5;
    }

    public String getName() {
        return "Rook";
    }
}
