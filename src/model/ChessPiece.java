package model;

public abstract class ChessPiece {
    private int _x;
    private int _y;
    private Player p;

    public enum Player {BLACK, WHITE};

    private ChessPiece(Player player, int xInit, int yInit) {
        p = (player == Player.WHITE) ? Player.WHITE : Player.BLACK;
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
        if (p == Player.WHITE) {
            return "white";
        } else {
            return "black";
        }
    }

    public Player getPlayer() {
        return p;
    }
  }
