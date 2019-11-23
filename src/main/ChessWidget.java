package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChessWidget extends JPanel implements ChessSpotListener, ActionListener {

    private ChessBoard _board;

    Player h = new HumanPlayer(Player.Color.WHITE);
    Player ai = new AIPlayer(Player.Color.BLACK, _board);

    public ChessWidget() {

        _board = new ChessBoard(h,ai);
        setLayout(new BorderLayout());
        add(_board, BorderLayout.CENTER);
        _board.addChessSpotListener(this);

        // setting up the bottom panel
        JPanel bottom_panel = new JPanel(new BorderLayout());
        JButton reset_button = new JButton("Restart game");
        reset_button.addActionListener(this);
        bottom_panel.add(reset_button, BorderLayout.EAST);

        add(bottom_panel,BorderLayout.SOUTH);
    }

    @Override
    public void spotEntered(ChessSpot spot) {
        if (_board.getSelected() != null) {
            return;
        }
        try {
            if (spot.getPiece().getPlayer().getColor() == h.getColor()) {
                spot.highlightSelectable();
            }
        } catch (NullPointerException e) {

        }

    }

    @Override
    public void spotExited(ChessSpot spot) {
        if (_board.getSelected() != spot) {
            spot.unhighlight();
        } else {

        }

    }

    @Override
    public void spotClicked(ChessSpot spot) {
        if (_board.getSelected() == spot) {
            _board.setSelected(null);
            spot.unhighlight();
        } else if (_board.getSelected() == null) {
            _board.setSelected(spot);
            spot.highlightSelected();
        } else {

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _board.resetPieces();

    }
}
