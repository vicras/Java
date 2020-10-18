package com.company;

import com.company.engine.field.FieldInterface;
import com.company.engine.move.MoveImpl;
import com.company.exception.PlayException;
import com.company.exception.PlayersNotFoundException;
import com.company.game.TicTacToe;
import com.company.game.TicTacToeImpl;
import com.company.player.PlayerImpl;

public class Main {

    public static void main(String[] args) throws PlayException, PlayersNotFoundException {
	// write your code here
        TicTacToe game = new TicTacToeImpl();
        PlayerImpl viktor = new PlayerImpl("viktor");
        PlayerImpl ivan = new PlayerImpl("ivan");
        game.setPlayers(viktor, ivan);
        game.startGame();
        game.makeMove(new MoveImpl(0,0),viktor);
        game.makeMove(new MoveImpl(2,2),ivan);
        game.makeMove(new MoveImpl(0,1),viktor);
        game.makeMove(new MoveImpl(2,0),ivan);
        game.makeMove(new MoveImpl(0,2),viktor);
        game.makeMove(new MoveImpl(1,2),ivan);
        FieldInterface field = game.getField();
        System.out.println(field);


    }
}
