<<<<<<< HEAD
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
        System.out.println("clicked");
        if (_board.getSelected() == spot) {
            System.out.println("clicked selected");
        } else {
            _board.setSelected(spot);
        }

    }

    @Override
    public void spotEntered(ChessSpot spot) {
        // TODO Auto-generated method stub
        System.out.println("spot entered " + spot);

    }

    @Override
    public void spotExited(ChessSpot spot) {
        // TODO Auto-generated method stub

    }
}
=======
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ChessWidget extends JPanel {

    private ChessBoard _board;
  

    public ChessWidget() {
        _board = new ChessBoard();
        setLayout(new BorderLayout());
        add(_board, BorderLayout.CENTER);

        Dimension preferred_size = new Dimension(500/8, 500/8);

    }
}
>>>>>>> 483cd11979130d6d286fc70656ba886cfc97ddd5
