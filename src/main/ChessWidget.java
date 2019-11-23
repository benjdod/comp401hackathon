package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JPanel;

public class ChessWidget extends JPanel implements ChessSpotListener {

    private ChessBoard _board;

    public ChessWidget() {
        _board = new ChessBoard();
        setLayout(new BorderLayout());
        add(_board, BorderLayout.CENTER);
        _board.addChessSpotListener(this);
<<<<<<< HEAD
        
=======
        Iterator<ChessSpot> i = _board.iterator();
        int count = 0;
        while(i.hasNext()) {
            i.next();
            count++;
        }
        System.out.println(count);
>>>>>>> 1d618ec19c7f11aa9b0d7567ca7f24f253dbabc5
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
