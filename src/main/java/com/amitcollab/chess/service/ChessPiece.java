package com.amitcollab.chess.service;

import com.amitcollab.chess.model.Directions;

import java.util.List;

public abstract class ChessPiece {

    //method to find allowed direction of the chess piece
    public abstract List<Directions> getAllowedDirections();
    //method for the max number of steps
    public abstract int getMaxSteps();
    //name of the piece as identifier, which will be input
    public abstract String name();
}
