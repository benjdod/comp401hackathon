package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

public class ChessBoard extends JPanel {

    private ChessSpot[][] _spots;
    private ChessSpot _selected; 

    public ChessBoard() {
        _spots = new ChessSpot[8][8];
        _selected = null;

        setLayout(new GridLayout(8,8));

        Dimension preferred_size = new Dimension(500/8, 500/8);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color setcolor;
                if ((i+j)%2 == 0) {
                    setcolor = new Color(0.47f,0.21f,0.11f);
                } else {
                    setcolor = new Color(0.87f,0.62f,0.53f);
                }
                _spots[i][j] = new ChessSpot(i,j,this,setcolor);
                _spots[i][j].setPreferredSize(preferred_size);
                add(_spots[i][j]);
            }
        }
    }

    public void addChessSpotListener(ChessSpotListener c) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                _spots[i][j].addChessSpotListener(c);
            }
        }
    }

    public void removeChessSpotListener(ChessSpotListener c) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                _spots[i][j].removeChessSpotListener(c);
            }
        }
    }

    public ChessSpot getSelected() {
        return _selected;
    }

    public void setSelected(ChessSpot s) {
        _selected = s;
    }

}