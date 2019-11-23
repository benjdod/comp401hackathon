package model;

import main.*;

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

    public abstract boolean getCanMoveToPosition(int x, int y);
    public abstract ArrayList<Move> getAllPossibleMoves();
    public abstract int getNumPoints();
    public abstract String getName(); // "King", "Queen", "Pawn", etc.

    public String getPieceColor() {
        return (_player.getColor() == Player.Color.WHITE) ? "white" : "black";
    }

    public Player getPlayer() {
        return _player;
    }
}
