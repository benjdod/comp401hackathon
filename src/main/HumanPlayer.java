package main;

public class HumanPlayer implements Player {
    private Player.Color _color;

    public HumanPlayer(Color color) {
        _color = color;
    }

    @Override
    public Move getNextMove(ChessBoard board) {
        return null; // TODO add user asking functionality through board.
    }

    @Override
    public Color getColor() {
        return _color;
    }
}
