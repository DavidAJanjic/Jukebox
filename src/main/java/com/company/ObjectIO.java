package com.company;

import java.io.*;
import java.util.ArrayList;

public class ObjectIO {
    static String filepath = "C://Users/Quantox/Desktop/Jukebox.txt";

    public static ArrayList<Song> readFile() throws IOException, ClassNotFoundException {
        ArrayList<Song> songs = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filepath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            songs = (ArrayList<Song>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            ois.close();
        }
        return songs;
    }

    public static void writeFile(Playlist playlist) {

        writeObjectToFile(playlist.getSongList());
    }

    public static void writeObjectToFile(ArrayList<Song> o) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filepath);
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
