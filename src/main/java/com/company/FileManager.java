package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager implements SongReader {

    public List<Song> readFile() {
        Scanner x = null;
        try {
            x = new Scanner(new File(AppConfig.filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> fileList = new ArrayList<>();
        while (x.hasNext()) {
            String a = x.nextLine();
            fileList.add(a);
        }
        List<Song> songs;
        songs = Parser.parse(fileList);
        return songs;
    }

    public void writeFile(Playlist playlist) {
        PrintStream myconsole = null;
        try {
            myconsole = new PrintStream(AppConfig.filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(myconsole);
        myconsole.print(Parser.parseOut(playlist.getSongList()));
    }
}
