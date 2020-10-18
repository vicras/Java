package com.company.leaderboard;

import com.company.engine.field.FieldState;
import com.company.player.Player;

import java.time.Duration;
import java.time.LocalDateTime;

public class RecordImpl implements GameRecord {

    private final Player player1;
    private final Player player2;
    private final Player winner;
    private final Duration duration;
    private final LocalDateTime gameTime;
    private final FieldState gameResult;

    private static final long serialVersionUID = 1L; // Версия 1

    public RecordImpl(Player player1, Player player2, Player winner, Duration duration, LocalDateTime gameTime, FieldState gameResult) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.duration = duration;
        this.gameTime = gameTime;
        this.gameResult = gameResult;
    }

    @Override
    public Player getPlayer1() {
        return player1;
    }

    @Override
    public Player getPlayer2() {
        return player2;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public LocalDateTime getGameTime() {
        return gameTime;
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public FieldState getGameResult() {
        return gameResult;
    }

    @Override
    public String toString() {
        var ans =new StringBuilder();
        ans.append("Result of game:\n" +
                "Player1 name:\t" + player1.getName() +"\n"+
                "Player2 name:\t" + player2.getName() +"\n"+
                "Duration (sec):\t" + duration +"\n"+
                "Game Date:\t" + gameTime + "\n");
        if(gameResult == FieldState.DRAW){
            ans.append("Game result:\tDraw");
        }else{
            ans.append("Game result:\t"+ gameResult+"\n");
            ans.append("Winner:\t"+((gameResult==FieldState.CROSSES_WIN)?player1.getName():player2.getName())+"\n");
        }
        return ans.toString();
    }
}
