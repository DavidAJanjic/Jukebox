package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public static List<String> readFile() throws FileNotFoundException {
//        Parser parser = new Parser();
        Scanner x = new Scanner(new File("C://Users/Quantox/Desktop/Jukebox.txt"));
        List<String> fileList = new ArrayList<>();
        while(x.hasNext()){
            String a = x.nextLine();
            fileList.add(a);
        }
        return  fileList;
    }

    public static void writeFile(SongList songList) throws FileNotFoundException {
//        Parser parser = new Parser();
        PrintStream myconsole = new PrintStream(new File("C://Users/Quantox/Desktop/Jukebox.txt"));
        System.setOut(myconsole);
        myconsole.print(Parser.parseOut(songList.getSongList()));
    }
}
