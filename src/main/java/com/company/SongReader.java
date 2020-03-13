package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface SongReader {

    static ArrayList<String> readFile() throws FileNotFoundException, IOException {
        return null;
    }

    static void writeFile(Playlist playlist) throws FileNotFoundException {

    }
}
