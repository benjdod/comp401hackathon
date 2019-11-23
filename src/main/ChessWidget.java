package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JPanel;

public class ChessWidget extends JPanel implements ChessSpotListener {

    private ChessBoard _board;

    Player h = new HumanPlayer(Player.Color.WHITE);
    Player ai = new HumanPlayer(Player.Color.BLACK);

    public ChessWidget() {
        _board = new ChessBoard();
        setLayout(new BorderLayout());
        add(_board, BorderLayout.CENTER);
        _board.addChessSpotListener(this);
        Iterator<ChessSpot> i = _board.iterator();
        int count = 0;
        while(i.hasNext()) {
            i.next();
            count++;
        }
        System.out.println(count);
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
        if (spot.getPiece().getPlayer().getColor() == h.getColor()) {
            spot.
        }
    }

    @Override
    public void spotExited(ChessSpot spot) {
        // TODO Auto-generated method stub

    }
}
