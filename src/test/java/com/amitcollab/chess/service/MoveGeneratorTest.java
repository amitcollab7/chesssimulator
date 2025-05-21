package com.amitcollab.chess.service;

import com.amitcollab.chess.model.Position;
import com.amitcollab.chess.service.impl.King;
import com.amitcollab.chess.service.impl.Pawn;
import com.amitcollab.chess.service.impl.Queen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class MoveGeneratorTest {


    @Test
    @DisplayName("King D5")
    void testKingMovesFromD5() {
        Position start = Position.fromString("D5");
        ChessPiece king = new King();
        List<String> moves = MoveGenerator.generate(start, king);

        assertThat(moves).containsExactlyInAnyOrder(
                "C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"
        );
    }

    @Test
    @DisplayName("Queen E4")
    void testQueenMovesFromE4() {
        Position start = Position.fromString("E4");
        ChessPiece queen = new Queen();
        List<String> moves = MoveGenerator.generate(start, queen);

        assertThat(moves).contains(
                "E5", "E6", "E7", "E8", "E3", "E2", "E1", "F4", "G4", "H4", "D4", "C4", "B4", "A4"
                , "F5", "G6", "H7", "D5", "C6", "B7", "A8", "F3", "G2", "H1", "D3", "C2", "B1"
        ).doesNotContain("E4").hasSize(27);
    }

    @Test
    @DisplayName("Pawn G1")
    void testPawnMovesFromG1() {
        Position start = Position.fromString("G1");
        ChessPiece pawn = new Pawn();
        List<String> moves = MoveGenerator.generate(start, pawn);

        assertThat(moves).containsExactly("G2");
    }

    @Test
    @DisplayName("King A1")
    void testKingAtCornerA1() {
        Position start = Position.fromString("A1");
        ChessPiece king = new King();
        List<String> moves = MoveGenerator.generate(start, king);

        assertThat(moves).containsExactlyInAnyOrder("A2", "B1", "B2");
    }

    @Test
    @DisplayName("Pawn C8")
    void testPawnAtTopEdge() {
        Position start = Position.fromString("C8");
        ChessPiece pawn = new Pawn();
        List<String> moves = MoveGenerator.generate(start, pawn);

        assertThat(moves).isEmpty();
    }
}
