package main;
/* Move object:
 * -> Stores a start coordinate and end coordinate.
 * -> Store the player doing the move
 * -> Immutable
 */
public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Player playerMoving;

    public Move(Player playerResponsible, int x1, int y1, int x2, int y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        playerMoving = playerResponsible;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Player getPlayerMoving() {
        return playerMoving;
    }
}
