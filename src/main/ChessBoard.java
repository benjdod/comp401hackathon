package main;

import javax.swing.JPanel;

import java.awt.Color;

public class ChessBoard extends JPanel {

    private ChessSpot[][] _spots;

    public ChessBoard() {
        _spots = new ChessSpot[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color setcolor;
                if ((i+j)%2 == 0) {
                    setcolor = new Color(0.47f,0.21f,0.11f);
                } else {
                    setcolor = new Color(0.87f,0.62f,0.53f);
                }
                _spots[i][j] = new ChessSpot(i,j,this,setcolor);
            }
        }
    }

}