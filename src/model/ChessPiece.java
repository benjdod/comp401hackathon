package model;

public abstract class ChessPiece {
    private int x;
    private int y;

    public abstract boolean getCanMoveToPosition(int x, int y);
    public abstract int getNumPoints();
    public abstract String getName(); // "King", "Queen", "Pawn", etc.

}
