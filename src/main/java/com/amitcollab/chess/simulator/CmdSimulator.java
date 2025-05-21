package com.amitcollab.chess.simulator;

import com.amitcollab.chess.model.Position;
import com.amitcollab.chess.service.ChessPiece;
import com.amitcollab.chess.service.ChessPieceFactory;
import com.amitcollab.chess.service.MoveGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@Profile("cli")
public class CmdSimulator implements ApplicationRunner {

    private final ChessPieceFactory factory;
    @Autowired
    public CmdSimulator(ChessPieceFactory factory){
        this.factory = factory;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.flush();

        String input = "";
        while(!input.equals("e")) {

            System.out.println("Enter piece name : ");
            String name = s.nextLine();
            System.out.println("Enter start position : ");
            String position = s.nextLine();

            try {
                ChessPiece piece = factory.get(name);
                Position start = Position.fromString(position);
                List<String> moves = MoveGenerator.generate(start, piece);
                if(moves.size()>0)
                    System.out.println("Possible moves are : "+String.join(", ", moves));
                else
                    System.out.println("No possible moves.");

            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            } finally {
                System.out.println("\nPress e to exit, and anything else to try more.");
                input = s.nextLine();
            }
        }


    }
}
