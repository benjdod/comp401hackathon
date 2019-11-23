package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChessSpot extends JPanel {

    private int _x, _y;
    private ChessBoard _board; 
    private Color _bgcolor;

    public ChessSpot(int x, int y, ChessBoard board, Color spotcolor) {
        // don't need input validation
        _x = x;
        _y = y;
        _board = board;
        _bgcolor = spotcolor;

        setBackground(_bgcolor);
    }

    // public void paintComponent(Graphics g) {
	// 	super.paintComponent(g);

	// 	Graphics2D g2d = (Graphics2D) g.create();
	// 	if (isHighlighted()) {
	// 		g2d.setColor(getHighlight());
	// 		g2d.setStroke(new BasicStroke(4));
	// 		g2d.drawRect(0, 0, getWidth(), getHeight());
	// 	}
	// 	if (!isEmpty()) {
	// 		g2d.setColor(getSpotColor());
	// 		g2d.fillOval(0, 0, this.getWidth()-1, this.getHeight()-1);
	// 	}
    // }
    
    // private void trigger_update() {		
	// 	repaint();

	// 	new Thread(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				Thread.sleep(50);
	// 			} catch (InterruptedException e) {
	// 			}
	// 			repaint();
	// 		}
	// 	}).start();

	// }
}