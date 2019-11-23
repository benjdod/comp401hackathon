package main;

public interface ChessSpotListener {
    void spotClicked(ChessSpot spot);
	void spotEntered(ChessSpot spot);
	void spotExited(ChessSpot spot);
}