package Application;

import Boardgame.Board;
import Chess.ChessMatch;


public class Programm {
    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
        // TESTE TESTE 
    }
}
