package Chess.pieces;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);
        // above (acima)
        p.setValues(position.getRow() - 1, position.getCollumn() );
        while(getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // left (esquerda)
        p.setValues(position.getRow(), position.getCollumn() - 1 );
        while(getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
            p.setCollumn(p.getCollumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // right (direita)
        p.setValues(position.getRow(), position.getCollumn() + 1 );
        while(getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
            p.setCollumn(p.getCollumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // below (abaixo)
        p.setValues(position.getRow() + 1, position.getCollumn() );
        while(getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }

        return mat;
    }
}
