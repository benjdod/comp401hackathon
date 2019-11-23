package main;
import model.ChessPiece;

import java.util.ArrayList;
import java.util.Random;

public class AIPlayer implements Player {

    private Player.Color _color;
    private ChessBoard _board;

    public AIPlayer(Color color) {
        _color = color;
    }

    public void setBoard(ChessBoard board) {
        _board = board;
    }

    public Move getNextMove() {
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
        if (b == null) {
            System.out.println("NULL");
        }
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

        // Quick check so that the AI won't care about the opponent killing it's
        //   king AFTER the other king has already died.
        if (getPointsForBoard(newBoard) > 500) {
            return getPointsForBoard(newBoard);
        }

        newBoard.applyMove(m);
        Move[] moves = allPossibleMovesFor(_board.getPlayerNot(this), newBoard);
        int lowestScoreAfterM = 10000;  // Every score is lower than this, so it will be replaced.
        for (Move move : moves) {
            ChessBoard temp = newBoard.clone();
            temp.applyMove(move);
            int numPoints = getPointsForBoard(temp);
            if (numPoints < lowestScoreAfterM) {
                lowestScoreAfterM = numPoints;
            }
        }
        return lowestScoreAfterM;
    }

    private int getPointsForBoard(ChessBoard b) {
        int points = 0;
        for (ChessSpot s : b) {
            if (s.isEmpty()) continue;
            if (s.getPiece().getPlayer().getColor() == getColor()) {
                points += s.getPiece().getNumPoints();
            } else {
                points -= s.getPiece().getNumPoints();
            }
        }
        return points;
    }
}
