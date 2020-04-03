package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SongReader<T> {

    List<T> readFile();

    void writeFile(Playlist playlist);
}
