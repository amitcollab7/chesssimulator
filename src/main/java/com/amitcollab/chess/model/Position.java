package com.amitcollab.chess.model;

public record Position(int row, char col) {

    public boolean isValid(){
        return (row>=1 && row<=8) && (col>='A' && col<='H');
    }

    public static Position fromString(String position){
        if (position.length() != 2 || !position.matches("^[A-Z]\\d$")) {
            throw new IllegalArgumentException("Invalid position on chess board.");
        }
        int row = Integer.parseInt(position.substring(1));
        char col = position.charAt(0);

        if(row<1 || row>8){
            throw new IllegalArgumentException("row should only be between 1 to 8 (inclusive)");
        }

        if(col<'A' || col>'H') {
            throw new IllegalArgumentException("row should only be between A to H (inclusive)");
        }

        return new Position(row , col);
    }

    @Override
    public String toString(){
        return "" + col + row;
    }
}
