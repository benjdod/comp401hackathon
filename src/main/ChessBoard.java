package main;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Iterator;
import java.awt.Dimension;

public class ChessBoard extends JPanel implements Iterable<ChessSpot> {

    private ChessSpot[][] _spots;
    private ChessSpot _selected;
    private Player _black, _white;

    private ChessBoard(ChessSpot[][] spots, Player white, Player black) {
        _spots = spots;
        _selected = null;
        _black = black;
        _white = white;

        setLayout(new GridLayout(8,8));
    }

    public ChessBoard(Player white, Player black) {
        this(new ChessSpot[8][8], white, black);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color setcolor;
                if ((i+j)%2 == 0) {
                    setcolor = new Color(0.47f,0.21f,0.11f);
                } else {
                    setcolor = new Color(0.87f,0.62f,0.53f);
                }
                _spots[i][j] = new ChessSpot(i,j,this,setcolor);
                _spots[i][j].setPreferredSize(new Dimension(75, 75));
                add(_spots[i][j]);
            }
        }
    }

    public ChessSpot getSpotAt(int x, int y) {
        return _spots[x][y];
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
        ChessSpot old_selection = _selected;
        _selected = s;
        try {s.selectSpot();} catch (NullPointerException e) {}
        try {old_selection.deselectSpot();} catch (NullPointerException e) {}
    }

    @Override
    public Iterator<ChessSpot> iterator() {
        return new ChessBoardIterator(this);
    }

    public ChessBoard clone() {
        ChessSpot[][] newSpots = new ChessSpot[_spots.length][_spots[0].length];
        ChessBoard output = new ChessBoard(newSpots, );
        for (int i = 0; i < newSpots.length; i++) {
            for (int j = 0; j < newSpots[0].length; j++) {
                newSpots[i][j] = _spots[i][j].clone(output);
            }
        }
        return output;
    }

    public Player getPlayerNot(Player p) {
        return (p.getColor() == Player.Color.WHITE) ? _black : _white;
    }
}