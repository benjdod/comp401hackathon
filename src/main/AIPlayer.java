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
        for (Move m : movesThisBotCouldMake()) {
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

    private Move[] movesThisBotCouldMake() {
        ArrayList<Move> output = new ArrayList<>();
        for (ChessSpot spot : _board) {
            if (spot.isEmpty() || spot.getPiece().getPlayer().getColor() != getColor()) {
                continue;
            }

            // We now know that the piece is our piece, and not just some empty square or the opponents piece.
            ChessPiece piece = spot.getPiece();

        }
    }


//    public Move getRandomMoveFrom(int x, int y) {
//      ArrayList<Move> eligibleMoves = new ArrayList<>();
//
//      for (ChessSpot s : _board) {
//          if (s.getPiece() != null && s.getPiece().getPlayer().getColor().equals(_color)) {
//              ChessPiece p = s.getPiece();
//              if (p.getCanMoveToPosition(x, y)) {
//                  eligibleMoves.add(new Move(this, s.getPiece().getX(), s.getPiece().getY(), x, y));
//              }
//          }
//      }
//
//        Random r = new Random();
//        int moveToSelect = r.nextInt(eligibleMoves.size()-1);
//
//        return (eligibleMoves.size() > 0) ? eligibleMoves.get(moveToSelect) : null;
//    }

}
