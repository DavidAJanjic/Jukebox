package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectIO implements SongReader {

    @Override
    public List<Song> readFile() {
        ArrayList<Song> songs = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(AppConfig.filepath);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            songs = (ArrayList<Song>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return songs;
    }

    @Override
    public void writeFile(Playlist playlist) {
        writeObjectToFile(playlist.getSongList());
    }

    public static void writeObjectToFile(List<Song> o) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(AppConfig.filepath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            System.out.println("Object succesfully written to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
