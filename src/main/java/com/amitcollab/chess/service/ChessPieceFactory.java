package com.amitcollab.chess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ChessPieceFactory {

    private Map<String, ChessPiece> chessPieceMap  = new HashMap<>();

    @Autowired
    public ChessPieceFactory(List<ChessPiece> chessPieces){
        //loading the objects to factory map
        chessPieces.forEach(chessPiece ->chessPieceMap.put( chessPiece.name(), chessPiece));
    }

    public ChessPiece get(String name){
        if(chessPieceMap.containsKey(name)){
            return chessPieceMap.get(name);
        } else {
            throw new IllegalArgumentException(name+" is not valid chess piece.");
        }
    }
}
