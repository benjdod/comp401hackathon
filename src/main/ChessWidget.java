package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ChessWidget extends JPanel implements ChessSpotListener {

    private ChessBoard _board;

    public ChessWidget() {
        _board = new ChessBoard();
        setLayout(new BorderLayout());
        add(_board, BorderLayout.CENTER);
        _board.addChessSpotListener(this);
    }

    @Override
    public void spotClicked(ChessSpot spot) {
        if (_board.getSelected() == spot) {
            _board.setSelected(null);
        } else if (_board.getSelected() == null) {
            _board.setSelected(spot);
        } else {

        }

    }

    @Override
    public void spotEntered(ChessSpot spot) {
        // TODO Auto-generated method stub

    }

    @Override
    public void spotExited(ChessSpot spot) {
        // TODO Auto-generated method stub

    }
}
