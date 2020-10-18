package com.company.leaderboard.serializer;

import com.company.leaderboard.GameRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializerImpl implements Serializer {

    private final String directoryPath = ".tictactoe/save/";
    final File homeDirectory = new File(System.getProperty("user.home"));
    final File fileDirectory = new File(homeDirectory + "/" + directoryPath);


    @Override
    public void storeData(List<GameRecord> list, String file) {
        try (ObjectOutputStream encode = new ObjectOutputStream(new FileOutputStream(new File(fileDirectory,file)))) {
            encode.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GameRecord> restoreData(String file) {

        try (ObjectInputStream decode = new ObjectInputStream(new FileInputStream(new File(fileDirectory,file)))) {
            return (List<GameRecord>) decode.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            createDirectory(file);
        }
        return new ArrayList<>();
    }


    private void createDirectory(final String fileName) {
        this.fileDirectory.mkdirs();
        final File file= new File(fileDirectory, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
