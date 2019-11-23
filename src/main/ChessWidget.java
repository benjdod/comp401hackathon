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
    private Player turn;
    private Player _h, _a;

    public ChessWidget() {
        HumanPlayer h = new HumanPlayer(Player.Color.WHITE);
        AIPlayer a = new AIPlayer(Player.Color.BLACK, _board);
        _h = h; _a = a;
        turn = h;
        _board = new ChessBoard(h, a);
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
            // Check if this spot is a valid move from the selected spot.
            if (_board.getSelected().getPiece().getCanMoveToPosition(spot.getSpotX(), spot.getSpotY())) {
                spot.highlightSelectable();
                // This means that the spot is valid for moving to.
            }
        } else {
            try {
                if (_board.getSelected() == null && spot.getPiece().getPlayer().getColor() == turn.getColor()) {
                    spot.highlightSelectable();
                }
            } catch (NullPointerException e) {
            }
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
            Move clickedMove = new Move(turn, _board.getSelected().getSpotX(),
                    _board.getSelected().getSpotY(), spot.getSpotX(), spot.getSpotY());
            turn = _board.getPlayerNot(turn);
            _board.applyMove(clickedMove);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        _board.resetPieces();
        turn = _h;
    }
}
