package com.amitcollab.chess.model;

public record Position(int row, char col) {
    public Position{
        if(row<1 && row>8){
            throw new IllegalArgumentException("row should only be between 1 to 8 (inclusive)");
        }

        if(col<'A' && col>'H') {
            throw new IllegalArgumentException("row should only be between A to H (inclusive)");
        }
    }


    public boolean isValid(){
        return (row>=1 && row<=8) && (col>='A' && col<='H');
    }

    @Override
    public String toString(){
        return "" + (char) col + row;
    }
}
