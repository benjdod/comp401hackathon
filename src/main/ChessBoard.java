package main;

import javax.swing.JPanel;

import model.*;

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

        resetPieces();
    }

    public ChessSpot getSpotAt(int x, int y) {
        return _spots[x][y];
    }

    public void applyMove(Move move) {
        _spots[move.getEndX()][move.getEndY()].setPiece(_spots[move.getStartX()][move.getStartY()].getPiece());
        _spots[move.getStartX()][move.getStartY()].setPiece(null);
        // TODO add special cases like pawns slaughtering with hook thing
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

    // this should ONLY be run when starting a new game
    public void resetPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                _spots[i][j].setPiece(null);
            }
        }

        _spots[0][0].setPiece(new Rook(this,_white,0,0));
        _spots[1][0].setPiece(new Knight(this,_white,1,0));
        _spots[2][0].setPiece(new Bishop(this,_white,2,0));
        _spots[3][0].setPiece(new Queen(this,_white,3,0));
        _spots[4][0].setPiece(new King(this,_white,4,0));
        _spots[5][0].setPiece(new Bishop(this,_white,5,0));
        _spots[6][0].setPiece(new Knight(this,_white,6,0));
        _spots[7][0].setPiece(new Rook(this,_white,7,0));

        _spots[0][1].setPiece(new Pawn(this,_white,0,1));
        _spots[1][1].setPiece(new Pawn(this,_white,1,1));
        _spots[2][1].setPiece(new Pawn(this,_white,2,1));
        _spots[3][1].setPiece(new Pawn(this,_white,3,1));
        _spots[4][1].setPiece(new Pawn(this,_white,4,1));
        _spots[5][1].setPiece(new Pawn(this,_white,5,1));
        _spots[6][1].setPiece(new Pawn(this,_white,6,1));
        _spots[7][1].setPiece(new Pawn(this,_white,7,1));

        _spots[0][7].setPiece(new Rook(this,_black,0,7));
        _spots[1][7].setPiece(new Knight(this,_black,1,7));
        _spots[2][7].setPiece(new Bishop(this,_black,2,7));
        _spots[3][7].setPiece(new King(this,_black,3,7));
        _spots[4][7].setPiece(new Queen(this,_black,4,7));
        _spots[5][7].setPiece(new Bishop(this,_black,5,7));
        _spots[6][7].setPiece(new Knight(this,_black,6,7));
        _spots[7][7].setPiece(new Rook(this,_black,7,7));
        
        _spots[0][6].setPiece(new Pawn(this,_black,0,6));
        _spots[1][6].setPiece(new Pawn(this,_black,1,6));
        _spots[2][6].setPiece(new Pawn(this,_black,2,6));
        _spots[3][6].setPiece(new Pawn(this,_black,3,6));
        _spots[4][6].setPiece(new Pawn(this,_black,4,6));
        _spots[5][6].setPiece(new Pawn(this,_black,5,6));
        _spots[6][6].setPiece(new Pawn(this,_black,6,6));
        _spots[7][6].setPiece(new Pawn(this,_black,7,6));

    }
    
    public ChessBoard clone() {
        ChessSpot[][] newSpots = new ChessSpot[_spots.length][_spots[0].length];
        ChessBoard output = new ChessBoard(newSpots, getWhite(), getBlack());
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

    public Player getWhite() {
        return _white;
    }

    public Player getBlack() {
        return _black;
    }
}