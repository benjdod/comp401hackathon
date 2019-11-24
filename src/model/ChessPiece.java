package model;

import main.ChessBoard;
import main.ChessSpot;
import main.Move;
import main.Player;

import java.util.ArrayList;

public abstract class ChessPiece {
    protected int _x;
    protected int _y;
    protected Player _player;
    protected ChessBoard _board;

    protected ChessPiece(ChessBoard b, Player player, int xInit, int yInit) {
        _player = player;
        _x = xInit;
        _y = yInit;
        _board = b;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public boolean getCanMoveToPosition(int x, int y) {
        Move thisMove = new Move(getPlayer(), getX(), getY(), x, y);
        for (Move m : getAllPossibleMoves()) {
            if (m.equals(thisMove)) return true;
        }
        return false;
    }

    public abstract ArrayList<Move> getAllPossibleMoves();
    public abstract int getNumPoints();
    public abstract String getName(); // "King", "Queen", "Pawn", etc.

    public Player.Color getPieceColor() {
        return (_player.getColor() == Player.Color.WHITE) ? Player.Color.WHITE : Player.Color.BLACK;
    }

    public Player getPlayer() {
        return _player;
    }

    public ArrayList<Move> getLineMovesInDirection(int dx, int dy) {
        ArrayList<Move> output = new ArrayList<Move>();
        int currentX = this.getX();
        int currentY = this.getY();

        for (int x = 0; x < 8; x++) {
            currentX += dx;
            currentY += dy;
            if (currentX > 7 || currentY > 7 || currentX < 0 || currentY < 0) {
                break;
            }

            Move thisMove = new Move(getPlayer(), this.getX(), this.getY(), currentX, currentY);
            ChessSpot thisSpot = _board.getSpotAt(currentX, currentY);

            // This runs for each spot in a row going away from the start position.

            if (thisSpot.isEmpty()) {
                output.add(thisMove);
                continue;
            }

            Player.Color thisColor = thisSpot.getPiece().getPieceColor();

            if (thisColor == getPlayer().getColor()) {
                break;
            }

            // If this runs, the color of this spot is the opposite of our color.
            output.add(thisMove);
            break;
        }
        return output;
    }

    public void setX(int x) {
        _x = x;
    }

    public void setY(int y) {
        _y = y;
    }
}
