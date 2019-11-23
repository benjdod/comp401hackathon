package main;

public class HumanPlayer implements Player {
    private Player.Color _color;

    public HumanPlayer(Color color) {
        _color = color;
    }

    @Override
    public Color getColor() {
        return _color;
    }
}
