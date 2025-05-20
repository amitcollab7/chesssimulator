package com.amitcollab.chess.model;

public enum Directions {
    NORTH(1, 0),
    SOUTH(-1, 0),
    EAST(0, 1),
    WEST(0, -1),
    NORTHEAST(1, 1),
    NORTHWEST(1, -1),
    SOUTHEAST(-1, 1),
    SOUTHWEST(-1, -1);

    final int rowDir;
    final int colDir;

    Directions(int row, int col) {
        this.rowDir = row;
        this.colDir = col;
    }

    public Position move(Position from) {
        return new Position(from.row() + rowDir, (char)(from.col() + colDir));
    }
}