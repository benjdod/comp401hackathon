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


    }
}