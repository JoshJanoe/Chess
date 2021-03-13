package com.chess.engine.player;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.concurrent.Future;

import static java.text.BreakIterator.DONE;

/**
 * Created by Josh Janoe on 3/10/21 with guidance from Java Chess Programming Video series on YouTube by Software Architecture & Design
 * When finished guided version will be labeled Version 0 or V0
 */
public class MoveTransition {

    private final Board transitionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransition (final Board transitionBoard, 
                           final Move move,
                           final MoveStatus moveStatus){
        this.transitionBoard = transitionBoard;
        this.move = move;
        this.moveStatus = moveStatus;
    }

    public MoveStatus getMoveStatus() {
        return this.moveStatus;
    }

    public Board getTransitionBoard(){
        return this.transitionBoard;
    }
}
