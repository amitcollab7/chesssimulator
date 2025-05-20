package com.amitcollab.chess.simulator;

import com.amitcollab.chess.model.Position;
import com.amitcollab.chess.service.ChessPiece;
import com.amitcollab.chess.service.ChessPieceFactory;
import com.amitcollab.chess.service.MoveGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
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

            if (position.length() != 2 || !position.matches("^[A-Z]\\d$")) {
                System.out.println("Please provide correct input for position...");
                System.out.println("Press e to exit, and anything else to try more.");
                input = s.next();
                continue;
            }

            try {
                ChessPiece piece = factory.get(name);
                int r = Integer.parseInt(position.substring(1));
                char c = position.charAt(0);
                Position start = new Position(r , c);
                List<String> moves = MoveGenerator.generate(start, piece);
                System.out.println("Possible moves are : "+String.join(", ", moves));
                //moves.forEach(System.out::println);
            } catch (IllegalArgumentException e){
                System.out.println("Piece name does not exist.");
                continue;
            }

            System.out.println("\nPress e to exit, and anything else to try more.");
            input = s.nextLine();
        }


    }
}
