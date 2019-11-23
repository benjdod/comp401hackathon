package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
		ChessSpot s = _board.getSpotAt(_x, _y);
		if (_x < 7) {
			_x++;
		} else {
			_x = 0;
			_y++;
		}
		return s;
	}
    
}