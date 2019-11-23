package main;
import model.ChessPiece;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer implements Player {

    private Player.Color _color;
    private ChessBoard _board;

    public AIPlayer(Color color, ChessBoard board) {
        _color = color;
        _board = board;
    }

    @Override
    public Move getNextMove(ChessBoard board) {
        /* This method holds the AI behind this player.
         * Basic idea: evaluate EVERY possible move that this bot
         *   could make, and then choose the one that is sure to
         *   result in largest point advantage for the bot.
         * This will involve a ton of virtual chessboards
         */
        Move best = null;
        for (Move m : allPossibleMovesFor(this, _board)) {
            if (best == null || getWorstCaseAfter(best) < getWorstCaseAfter(m)) {
                best = m;
            }
        }

        return best;
    }

    @Override
    public Color getColor() {
        return _color;
    }

    private Move[] allPossibleMovesFor(Player p, ChessBoard b) {
        ArrayList<Move> output = new ArrayList<>();
        for (ChessSpot spot : b) {
            if (spot.isEmpty() || spot.getPiece().getPlayer().getColor() != p.getColor()) {
                continue;
            }

            // We now know that the piece is our piece, and not just some empty square or the opponents piece.
            // This means that we can add all moves that the piece can make to the output.
            ChessPiece piece = spot.getPiece();
            for (Move m : piece.getAllPossibleMoves()) {
                output.add(m);
            }
        }
        return output.stream().toArray(Move[]::new);
    }

    private int getWorstCaseAfter(Move m) {
        ChessBoard newBoard = _board.clone();
        newBoard.applyMove(m);
        Move[] moves = allPossibleMovesFor(_board.getPlayerNot(this), newBoard);
        for ()
    }
}
