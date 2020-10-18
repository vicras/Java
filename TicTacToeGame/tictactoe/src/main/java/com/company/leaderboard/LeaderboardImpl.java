package com.company.leaderboard;

import com.company.leaderboard.serializer.Serializer;
import com.company.leaderboard.serializer.SerializerImpl;

import java.util.List;

public class LeaderboardImpl implements Leaderboard {

    private final List<GameRecord> list;
    private final Serializer serializer;
    private final String path = "gamerecordsdb.bin";

    public LeaderboardImpl(Serializer serializer) {
        this.serializer = serializer;
        list = restoreRecords();
    }

    private List<GameRecord> restoreRecords() {
        return serializer.restoreData(path);
    }

    private void storeRecords(List<GameRecord> list) {
        serializer.storeData(list, path);
    }

    @Override
    public void addNewRecord(GameRecord record) {
        list.add(record);
        storeRecords(list);
    }

    @Override
    public List<GameRecord> getRecords() {
        return list;
    }

    public static void main(String[] args) {
        new LeaderboardImpl(new SerializerImpl());
    }
}
