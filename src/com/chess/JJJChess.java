package com.chess;

import com.chess.engine.board.Board;
import com.chess.gui.Table;

/**
 * Created by Josh Janoe on 3/10/21 with guidance from Java Chess Programming Video series on YouTube by Software Architecture & Design
 * When finished guided version will be labeled Version 0 or V0
 */
public class JJJChess {

    public static void main(String[] args) {

        Board board = Board.createStandardBoard();

        System.out.println(board);

        Table table = new Table();

    }

}
