package com.amitcollab.chess.service.impl;

import com.amitcollab.chess.model.Directions;
import com.amitcollab.chess.service.ChessPiece;

import java.util.List;

public class Queen extends ChessPiece {
    @Override
    public List<Directions> getAllowedDirections() {
        return List.of(Directions.NORTH, Directions.SOUTH, Directions.EAST, Directions.WEST,
                Directions.NORTHEAST, Directions.NORTHWEST, Directions.SOUTHEAST, Directions.SOUTHWEST);
    }

    @Override
    public int getMaxSteps() {
        return 7;
    }

    @Override
    public String name() {
        return "Queen";
    }
}
