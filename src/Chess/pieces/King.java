package Chess.pieces;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }
    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        // #Special move castling

        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            // #Special move castling Kingside rook
            Position posT1 = new Position(position.getRow(), position.getCollumn() + 3 );
            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getCollumn() + 1 );
                Position p2 = new Position(position.getRow(), position.getCollumn() + 2 );
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null ){
                    mat[position.getRow()][position.getCollumn() + 2] = true;
                }
            }
            // #Special move castling Queenside rook
            Position posT2 = new Position(position.getRow(), position.getCollumn() - 4 );
            if(testRookCastling(posT2)){
                Position p1 = new Position(position.getRow(), position.getCollumn() - 1 );
                Position p2 = new Position(position.getRow(), position.getCollumn() - 2 );
                Position p3 = new Position(position.getRow(), position.getCollumn() - 3 );
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getCollumn() - 2] = true;
                }
            }
        }
        return mat;
    }
}
