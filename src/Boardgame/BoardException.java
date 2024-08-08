package Boardgame;

import java.io.Serial; // <-- same

public class BoardException extends RuntimeException{
    @Serial // Possivel erro <--
    private static final long serialVersionUID = 1L;

    public BoardException(String msg){
        super(msg);
    }
}
