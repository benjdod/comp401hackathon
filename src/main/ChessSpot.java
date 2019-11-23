package main;

import java.awt.BorderLayout;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ChessPiece;

public class ChessSpot extends JPanel implements MouseListener {

    final public static Color SELECTED_COLOR = new Color(0.8f, 0.1f, 0.4f);
    final public static Color HIGHLIGHT_COLOR = new Color(0.8f, 0.85f, 0.2f);

    private int _x, _y;
    private ChessBoard _board;
    private Color _bgcolor, _hcolor;
    private boolean _is_highlighted;
    private boolean _has_piece;
    private ChessPiece _piece;

    private ArrayList<ChessSpotListener> _listeners = new ArrayList<ChessSpotListener>();

    public ChessSpot(int x, int y, ChessBoard board, Color spotcolor) {
        // don't need input validation
        _x = x;
        _y = y;
        _board = board;
        _bgcolor = spotcolor;
        _hcolor = HIGHLIGHT_COLOR;
        _piece = null;
        
        setBackground(_bgcolor);

        // FOR HANDLING IMAGES

        setLayout(new BorderLayout());
        JLabel image = new JLabel(new ImageIcon("img/testdim75.png"));
        add(image,BorderLayout.CENTER);

        addMouseListener(this);
    }

    public int getSpotX() {
        return _x;
    }

    public int getSpotY() {
        return _y;
    }

    public boolean isHighlighted() {
        return _is_highlighted;
    }

    public boolean isEmpty() {
        return (_piece == null);
    }

    public ChessPiece getPiece() {
        return _piece;
    }

    public void setPiece(ChessPiece piece) {
        _piece = piece;
    }

    public void selectSpot() {
        trigger_update();
    }

    public void deselectSpot() {
        trigger_update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        if (_board.getSelected() == this) {
            g2d.setColor(SELECTED_COLOR);
            g2d.setStroke(new BasicStroke(4));
            g2d.drawRect(0, 0, getWidth(), getHeight());
        } else {

        }
        // if (!isEmpty()) {
        // g2d.setColor(getSpotColor());
        // g2d.fillOval(0, 0, this.getWidth()-1, this.getHeight()-1);
        // }
    }

    private void trigger_update() {
        repaint();

        new Thread(new Runnable() {
        public void run() {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
            repaint();
        }

        }).start();

    }

    public void addChessSpotListener(ChessSpotListener c) {
        _listeners.add(c);
    }

    public void removeChessSpotListener(ChessSpotListener c) {
        _listeners.remove(c);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (ChessSpotListener c : _listeners) {
            c.spotClicked(this);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (ChessSpotListener c : _listeners) {
            c.spotEntered(this);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (ChessSpotListener c : _listeners) {
            c.spotExited(this);
        }
    }

    public ChessSpot clone(ChessBoard newBoard) {
        return new ChessSpot(_x, _y, newBoard, _bgcolor);
    }
}