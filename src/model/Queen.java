package model;

public class Queen extends ChessPiece {

    public Queen (ChessPiece.Player, )
    public boolean getCanMoveToPosition(int x, int y) {
        return (this.getX() == x || this.getY() == y ||
        this.getX() + this.getY() == x + y || this.getY() - this.getX() == y - x) ? true : false;
    }

    public int getNumPoints() {
        return 9;
    }

    public String getName() {
        return "Queen";
    } // "King", "Queen", "Pawn", etc.
}
