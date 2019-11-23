package model;

import main.*;

public abstract class ChessPiece {
    private int _x;
    private int _y;
    private Player.Color _color;
    private ChessBoard _board;

    protected ChessPiece(ChessBoard b, Player.Color player, int xInit, int yInit) {
        _color = (player == Player.Color.WHITE) ? Player.Color.WHITE : Player.Color.BLACK;
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

    public abstract boolean getCanMoveToPosition(int x, int y);
    public abstract int getNumPoints();
    public abstract String getName(); // "King", "Queen", "Pawn", etc.

    public String getPieceColor() {
        if (_color == Player.Color.WHITE) {
            return "white";
        } else {
            return "black";
        }
    }

    public Player.Color getPlayer() {
        return _color;
    }
  }
