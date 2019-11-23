package model;

import main.ChessBoard;
import main.Move;
import main.Player;

import java.util.ArrayList;

public class Pawn extends ChessPiece {

    public Pawn(ChessBoard board, Player player, int startX, int startY) {
        super(board, player, startX, startY);
    }

    @Override
    public boolean getCanMoveToPosition(int x, int y) {
        boolean distTwo = false;
        boolean distOne = getAllPossibleMoves().get(0).getEndX() == x && getAllPossibleMoves().get(0).getEndY() == y;
        try {
            distTwo = getAllPossibleMoves().get(1).getEndX() == x && getAllPossibleMoves().get(1).getEndY() == y;
        } catch (Exception e) {}
        return distOne || distTwo;
    }

    @Override
    public ArrayList<Move> getAllPossibleMoves() {
        ArrayList<Move> moves = new ArrayList<Move>();
        int x = this.getX();
        int y = this.getY();
        moves.add(new Move(getPlayer(), x, y, x, y+ ((getPlayer().getColor() == Player.Color.WHITE) ? 1 : -1)));
        if (thisPawnIsInStartRow()) {
            moves.add(new Move(getPlayer(), x, y, x, y+ ((getPlayer().getColor() == Player.Color.WHITE) ? 2 : -2)));
        }
        return moves;
    }

    public boolean thisPawnIsInStartRow()
    {
        if(getPlayer().getColor() == Player.Color.WHITE)
        {
            if(getY() == 1)
            {
                return true;
            }
        }
        else
        {
            if(getY() == 6)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumPoints() {
        return 1;
    }

    @Override
    public String getName() {
        return "Pawn";
    }
}
