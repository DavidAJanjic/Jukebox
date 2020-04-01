package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager implements SongReader {
    private static File file = new File("C://Users/Quantox/Desktop/Jukebox.txt");

    public static List<String> readFile() throws FileNotFoundException {
        Scanner x = new Scanner(file);
        List<String> fileList = new ArrayList<>();
        while (x.hasNext()) {
            String a = x.nextLine();
            fileList.add(a);
        }
        return fileList;
    }

    public static void writeFile(Playlist playlist) throws FileNotFoundException {
        PrintStream myconsole = new PrintStream(file);
        System.setOut(myconsole);
        myconsole.print(Parser.parseOut(playlist.getSongList()));
    }
}
