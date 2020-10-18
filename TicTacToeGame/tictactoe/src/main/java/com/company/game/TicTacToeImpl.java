package com.company.game;

import com.company.exception.PlayException;
import com.company.exception.PlayersNotFoundException;
import com.company.leaderboard.GameRecord;
import com.company.leaderboard.Leaderboard;
import com.company.leaderboard.LeaderboardImpl;
import com.company.leaderboard.RecordImpl;
import com.company.engine.Engine;
import com.company.engine.EngineInterface;
import com.company.engine.EngineObserver;
import com.company.engine.field.FieldInterface;
import com.company.engine.field.FieldState;
import com.company.engine.field.checker.WinPosition;
import com.company.engine.move.Move;
import com.company.engine.state.GameStatus;
import com.company.leaderboard.serializer.SerializerImpl;
import com.company.player.Player;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicTacToeImpl implements TicTacToe, EngineObserver {

    EngineInterface engine;
    private Player player1;
    private Player player2;
    List<TicTacToeObserver> observers;
    Leaderboard leaderboard;

    public TicTacToeImpl() {
        engine = new Engine();
        engine.addObserver(this);
        leaderboard = new LeaderboardImpl(new SerializerImpl());
        observers = new ArrayList<>();
    }

    private GameRecord makeRecord() {
        return new RecordImpl(
                player1,
                player2,
                getWinner(),
                engine.getGameDuration().getDuration().orElse(Duration.ZERO),
                LocalDateTime.now(),
                engine.getWinnerTeam());
    }

    private Player getWinner() {
        Player ans;
        switch (engine.getWinnerTeam()) {
            case CROSSES_WIN -> ans = player1;
            case NAUGHTS_WIN -> ans = player2;
            default -> ans = null;
        }
        return ans;
    }

    @Override
    public void startGame() throws PlayersNotFoundException {
        if (player1 == null || player2 == null)
            throw new PlayersNotFoundException("Players not found, login");
        engine.startGame(player1, player2);
    }

    @Override
    public void makeMove(Move move, Player player) throws PlayersNotFoundException {
        boolean isExist = false;
        switch (engine.getCurrentState().getStatus()) {
            case PLAYER_1_MOVE -> isExist = player.equals(engine.getPlayer1().orElseThrow(PlayersNotFoundException::new));
            case PLAYER_2_MOVE -> isExist = player.equals(engine.getPlayer2().orElseThrow(PlayersNotFoundException::new));
        }
        //assert(isExist) : "is exist = false";
        if (isExist) engine.newMove(move);
    }

    @Override
    public void setPlayers(Player player1, Player player2) throws PlayException {
        if (engine.getCurrentState().getStatus() == GameStatus.GAME_END) {
            this.player1 = player1;
            this.player2 = player2;
        } else throw new PlayException("You can't change players, before game will end");
    }

    @Override
    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    @Override
    public Optional<Player> getPlayer1() {
        return Optional.ofNullable(player1);
    }

    @Override
    public Optional<Player> getPlayer2() {
        return Optional.ofNullable(player2);
    }

    @Override
    public Optional<GameRecord> getGameResult() {
        if (engine.getWinnerTeam() == FieldState.IN_THE_PROCESS)
            return Optional.empty();
        return Optional.of(makeRecord());
    }

    @Override
    public WinPosition getWinPosition() {
        return engine.getWinPosition();
    }

    @Override
    public FieldInterface getField() {
        return engine.getField();
    }

    @Override
    public void addListeners(TicTacToeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeListeners(TicTacToeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void stateChanged(GameStatus status) {
        if (status.equals(GameStatus.GAME_END))
            leaderboard.addNewRecord(makeRecord());

        observers.forEach((i) -> i.stateChanged(status));
    }
}
