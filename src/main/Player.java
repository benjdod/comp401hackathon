package main;

public interface Player {
    public enum Color {WHITE, BLACK}

    Move getNextMove(ChessBoard board);
    Color getColor();
}
