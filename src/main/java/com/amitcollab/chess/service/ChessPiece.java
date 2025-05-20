package com.amitcollab.chess.service;

import com.amitcollab.chess.model.Directions;

import java.util.List;

public abstract class ChessPiece {

    public abstract List<Directions> getAllowedDirections();
    public abstract int getMaxSteps();
    public abstract String name();
}
