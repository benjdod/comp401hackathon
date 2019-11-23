package model;

import main.ChessBoard;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn(ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        ArrayList<Move> possibleMoves = getAllPossibleMoves();
        for (Move m : possibleMoves) {
            if (m.equals(new Move(this.getPlayer(), this.getX(), this.getY(), x, y))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        int x = this.getX();
        int y = this.getY();
        if (this.getPlayer() == _board.getWhite()) {
            if (_board.getSpotAt(x, y + 1).isEmpty()) {
                moves.add(new Move(_board.getWhite(), x, y, x, y + 1));
            }
            if (!_board.getSpotAt(x - 1, y + 1).isEmpty() &&
                    _board.getSpotAt(x - 1, y + 1).getPiece().getPlayer().getColor() == Player.Color.BLACK) {
                moves.add(new Move(_board.getWhite(), x, y, x - 1, y + 1));
            }
            if (!_board.getSpotAt(x + 1, y + 1).isEmpty() &&
                    _board.getSpotAt(x + 1, y + 1).getPiece().getPlayer().getColor() == Player.Color.BLACK) {
                moves.add(new Move(_board.getWhite(), x, y, x + 1, y + 1));
            }
            if (y == 1 && _board.getSpotAt(x, 2).isEmpty() && _board.getSpotAt(x, 3).isEmpty()) {
                moves.add(new Move(_board.getWhite(), x, y, x, y + 2));
            }
        } else {
            if (_board.getSpotAt(x, y - 1).isEmpty()) {
                moves.add(new Move(_board.getBlack(), x, y, x, y - 1));
            }
            if (!_board.getSpotAt(x + 1, y - 1).isEmpty() &&
                    _board.getSpotAt(x - 1, y + 1).getPiece().getPlayer().getColor() == Player.Color.WHITE) {
                moves.add(new Move(_board.getBlack(), x, y, x + 1, y - 1));
            }
            if (!_board.getSpotAt(x + 1, y + 1).isEmpty() &&
                    _board.getSpotAt(x + 1, y + 1).getPiece().getPlayer().getColor() == Player.Color.WHITE) {
                moves.add(new Move(_board.getBlack(), x, y, x - 1, y - 1));
            }
            if (y == 6 && _board.getSpotAt(x, 5).isEmpty() && _board.getSpotAt(x, 4).isEmpty()) {
                moves.add(new Move(_board.getBlack(), x, y, x, y - 2));
            }
        }
        return moves;
    }

    @Override
    public int getNumPoints() {
        return 1;
    }

    @Override
    public String getName() {
        return "Pawn";
    }
}
