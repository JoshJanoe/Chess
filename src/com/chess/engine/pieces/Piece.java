package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.Collection;

/**
 * Created by Josh Janoe on 3/8/21 with guidance from Java Chess Programming Video series on YouTube by Software Architecture & Design
 * When finished guided version will be labeled Version 0 or V0
 */
public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;
    protected final boolean isFirstMove;
    protected final PieceType pieceType;

    private final int cachedHashCode;

    Piece(final PieceType pieceType,
          final int piecePosition,
          final Alliance pieceAlliance,
          final boolean isFirstMove){
        this.piecePosition = piecePosition;
        this.pieceAlliance = pieceAlliance;
        this.pieceType = pieceType;
        this.isFirstMove = isFirstMove;
        this.cachedHashCode = computeHashCode();
    }

    private int computeHashCode() {
        int result = pieceType.hashCode();
        result = 31 * result + pieceAlliance.hashCode();
        result = 31 * result + piecePosition;
        result = 31 * result + (isFirstMove ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(final Object other){
        if (this==other){
            return true;
        }
        if(!(other instanceof Piece)){
            return false;
        }
        final Piece otherPiece = (Piece) other;
        return piecePosition == otherPiece.getPiecePosition()
                && pieceType == otherPiece.getPieceType()
                && pieceAlliance == otherPiece.getPieceAlliance()
                && isFirstMove == otherPiece.isFirstMove();
    }

    @Override
    public int hashCode(){
        return this.cachedHashCode;
    }

    public Alliance getPieceAlliance(){
        return this.pieceAlliance;
    }

    public int getPiecePosition(){
        return this.piecePosition;
    }

    public boolean isFirstMove(){
        return isFirstMove;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public int getPieceValue(){
        return this.pieceType.getPieceValue();
    }

    public abstract Piece movePiece(Move move);

    public enum PieceType {

        BISHOP("B", 300){
            @Override
            public boolean isKing(){
                return false;
            }

            @Override
            public boolean isRook(){
                return false;
            }
        },
        KING("K", 1000){
            @Override
            public boolean isKing(){
                return true;
            }

            @Override
            public boolean isRook(){
                return false;
            }
        },
        KNIGHT("N", 300){
            @Override
            public boolean isKing(){
                return false;
            }

            @Override
            public boolean isRook(){
                return false;
            }
        },
        PAWN("P", 100){
            @Override
            public boolean isKing(){
                return false;
            }

            @Override
            public boolean isRook(){
                return false;
            }
        },
        QUEEN("Q", 900){
            @Override
            public boolean isKing(){
                return false;
            }

            @Override
            public boolean isRook(){
                return false;
            }
        },
        ROOK("R", 500){
            @Override
            public boolean isKing(){
                return false;
            }

            @Override
            public boolean isRook(){
                return true;
            }
        };

        private String pieceName;
        private int pieceValue;

        PieceType(final String pieceName, final int pieceValue) {
            this.pieceName = pieceName;
            this.pieceValue = pieceValue;
        }

        @Override
        public String toString() {
            return this.pieceName;
        }

        public int getPieceValue() {
            return this.pieceValue;
        }

        public abstract boolean isKing();

        public abstract boolean isRook();

    }

}
