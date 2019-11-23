package model;

import main.*;

public abstract class ChessPiece {
    private int _x;
    private int _y;
    private Player.Color color;

    protected ChessPiece(Player.Color player, int xInit, int yInit) {
        color = (player == Player.Color.WHITE) ? Player.Color.WHITE : Player.Color.BLACK;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    public abstract boolean getCanMoveToPosition(ChessBoard b, int x, int y);
    public abstract int getNumPoints();
    public abstract String getName(); // "King", "Queen", "Pawn", etc.

    public String getPieceColor() {
        if (color == Player.Color.WHITE) {
            return "white";
        } else {
            return "black";
        }
    }

    public Player.Color getPlayer() {
        return color;
    }
  }
