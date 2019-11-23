package main;

import java.util.Iterator;

public class ChessBoardIterator implements Iterator<ChessSpot> {

    private ChessBoard _board;
	int _x;
	int _y;
	
	public ChessBoardIterator(ChessBoard board) {
		_board = board;
		_x = 0;
		_y = 0;
	}

	@Override
	public boolean hasNext() {
		return (_y < 8);
	}

	@Override
	public ChessSpot next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		Spot s = _board.getSpotAt(_x, _y);
		if (_x < 7) {
			_x++;
		} else {
			_x = 0;
			_y++;
		}
		return s;
	}
    
}