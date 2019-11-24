package main;
import model.ChessPiece;

import java.lang.reflect.Array;
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
        ArrayList<Move> bests = null;
        bests = replaceArrayContentsWithTheBest(allPossibleMovesFor(this, _board), _board);

        // Now, take each best, and then find the VERY best from those.
        int twoLayerBest = -10000;
        Move veryBest = null;
        System.out.println("A");
        for (Move best : bests) {
            ChessBoard temp = _board.clone();
            temp.applyMove(best);
            int worstPointsForThisHumanMove = 10000;
            System.out.println("B " + allPossibleMovesFor(_board.getPlayerNot(this), temp).size());
            for (Move humanMove : allPossibleMovesFor(_board.getPlayerNot(this), temp)) {
                ChessBoard reallyTemp = temp.clone();
                reallyTemp.applyMove(humanMove);
                ArrayList<Move> tempBests = allPossibleMovesFor(this, reallyTemp);
                int bestPointsForFutureBotMove = -10000;
                System.out.println("C");
                for (Move futureBotMove : tempBests) {
                    ChessBoard reallyReallyTemp = reallyTemp.clone();
                    reallyReallyTemp.applyMove(futureBotMove);
                    int  pointsForThis = getPointsForBoard(reallyReallyTemp);
                    System.out.println("D");
                    if (pointsForThis > bestPointsForFutureBotMove) {
                        bestPointsForFutureBotMove = pointsForThis;
                    }
                }
                if (bestPointsForFutureBotMove < worstPointsForThisHumanMove) {
                    worstPointsForThisHumanMove = bestPointsForFutureBotMove;
                }
            }
            if (worstPointsForThisHumanMove > twoLayerBest) {
                twoLayerBest = worstPointsForThisHumanMove;
                veryBest = best;
            }
        }
        return veryBest;
    }

    private ArrayList<Move> replaceArrayContentsWithTheBest(ArrayList<Move> bests, ChessBoard board) {
        ArrayList<Move> newBests = null;
        for (Move m : bests) {
            if (newBests == null || getWorstCaseAfter(newBests.get(0), board) < getWorstCaseAfter(m, board)) {
                newBests = new ArrayList<>();
                newBests.add(m);
            } else if (getWorstCaseAfter(newBests.get(0), board) == getWorstCaseAfter(m, board)) {
                newBests = new ArrayList<>();
                newBests.add(m);
            }
        }
        return newBests;
    }

    @Override
    public Color getColor() {
        return _color;
    }

    private ArrayList<Move> allPossibleMovesFor(Player p, ChessBoard b) {
        ArrayList<Move> output = new ArrayList<>();
        for (ChessSpot spot : b) {
            if (spot.isEmpty() || spot.getPiece().getPlayer().getColor() != p.getColor()) {
//                System.out.println("SPOT WRONG COLOR OR NULL");
                continue;
            }

            // We now know that the piece is our piece, and not just some empty square or the opponents piece.
            // This means that we can add all moves that the piece can make to the output.
            ChessPiece piece = spot.getPiece();
//            System.out.println("..SpotWithCorrectColor - has num of " + piece.getAllPossibleMoves());
            if (piece.getAllPossibleMoves() != null) {
                for (Move m : piece.getAllPossibleMoves()) {
                    output.add(m);
                }
            }
        }
//        System.out.println("RETURN SIZE: " + output.size());
        return output;
    }

    private int getWorstCaseAfter(Move m, ChessBoard board) {
        ChessBoard newBoard = board.clone();

        // Quick check so that the AI won't care about the opponent killing it's
        //   king AFTER the other king has already died.
        if (getPointsForBoard(newBoard) > 500) {
            return getPointsForBoard(newBoard);
        }

        newBoard.applyMove(m);
        ArrayList<Move> moves = allPossibleMovesFor(board.getPlayerNot(this), newBoard);
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
