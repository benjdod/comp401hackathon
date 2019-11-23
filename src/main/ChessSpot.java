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

    final public static Color SELECTABLE_COLOR = new Color(55/255f, 110/255f, 160/255f);
    final public static Color SELECTED_COLOR = new Color(95/255f, 176/255f, 226/255f);
    final public static Color MOVEABLE_COLOR = new Color(0.8f, 0.85f, 0.2f);

    private int _x, _y;
    private ChessBoard _board;
    private Color _bgcolor, _hcolor;
    private Color _active_highlight;
    private boolean _is_highlighted;
    private boolean _has_piece;
    private ChessPiece _piece;
    private String _iconfilepath;
    private JLabel _icon;

    private ArrayList<ChessSpotListener> _listeners = new ArrayList<>();

    public ChessSpot(int x, int y, ChessBoard board, Color spotcolor) {
        // don't need input validation
        _x = x;
        _y = y;
        _board = board;
        _bgcolor = spotcolor;
        _hcolor = MOVEABLE_COLOR;
        _piece = null;
        
        setBackground(_bgcolor);

        // FOR HANDLING IMAGES

        setLayout(new BorderLayout());
        _icon = new JLabel();
        add(_icon,BorderLayout.CENTER);

        addMouseListener(this);
    }

    public int getSpotX() {
        return _x;
    }

    public int getSpotY() {
        return _y;
    }

    public void highlightSelectable() {
        _active_highlight = SELECTABLE_COLOR;
        trigger_update();
    }

    public void highlightSelected() {
        _active_highlight = SELECTED_COLOR;
        trigger_update();
    }

    public void highlightMoveable() {
        _active_highlight = MOVEABLE_COLOR;
        trigger_update();
    }

    public void unhighlight() {
        _active_highlight = null;
        trigger_update();
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
        if (piece != null) {
            _piece = piece;
            String filepath = "img/"+_piece.getPlayer().getColor().name().toLowerCase()+_piece.getName().toLowerCase()+".png";
            System.out.println(filepath);
            _icon.setIcon(new ImageIcon(filepath));
            trigger_update();
        } else {
            _piece = null;
            _icon.setIcon(new ImageIcon("img/transparent"));
            trigger_update();
        }
        
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
        if (_active_highlight != null) {
            g2d.setColor(_active_highlight);
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

    public int getSpotXCoord() {
        return (getSpotX()+10) / getWidth();
    }

    public int getSpotYCoord() {
        return (getSpotY()+10) / getHeight();
    }
}