package com.amitcollab.chess.service.impl;

import com.amitcollab.chess.model.Directions;
import com.amitcollab.chess.service.ChessPiece;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pawn extends ChessPiece {
    @Override
    public List<Directions> getAllowedDirections() {
        //since we are implementing pawn only to upward direction
        return List.of(Directions.NORTH);
    }

    @Override
    public int getMaxSteps() {
        return 1;
    }

    @Override
    public String name() {
        return "Pawn";
    }
}
