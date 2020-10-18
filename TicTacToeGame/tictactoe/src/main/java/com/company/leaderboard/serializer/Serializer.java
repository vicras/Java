package com.company.leaderboard.serializer;

import com.company.leaderboard.GameRecord;

import java.util.List;

public interface Serializer {
    void storeData(List<GameRecord> list, String file);
    List<GameRecord> restoreData(String file);
}
