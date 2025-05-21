package com.amitcollab.chess.service;

import com.amitcollab.chess.model.Directions;
import com.amitcollab.chess.model.Position;

import java.util.ArrayList;
import java.util.List;

public class MoveGenerator {

    private MoveGenerator(){
    }

    public static List<String> generate(Position startPos, ChessPiece piece) {
        List<String> moves = new ArrayList<>();

        if(!startPos.isValid())
            return moves;
        //loop with the direction
        for (Directions dir : piece.getAllowedDirections()) {
            Position nextPos = startPos;
            //move until valid
            for (int i = 0; i < piece.getMaxSteps(); i++) {
                nextPos = dir.move(nextPos);
                if (!nextPos.isValid())
                    break;
                moves.add(nextPos.toString());
            }
        }
        return moves;
    }
}
