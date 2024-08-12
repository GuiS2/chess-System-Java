package Chess.pieces;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        // above (acima)
        p.setValues(position.getRow() - 1, position.getCollumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // below (abaixo)
        p.setValues(position.getRow() + 1, position.getCollumn());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // left (esquerda)
        p.setValues(position.getRow(), position.getCollumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // right (direita)
        p.setValues(position.getRow(), position.getCollumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // nw (noroste)
        p.setValues(position.getRow() -1, position.getCollumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // ne (nordeste)
        p.setValues(position.getRow() -1, position.getCollumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // sw (sudoeste)
        p.setValues(position.getRow() +1, position.getCollumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        // se (sudeste)
        p.setValues(position.getRow() +1, position.getCollumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCollumn()] = true;
        }
        return mat;
    }
}
