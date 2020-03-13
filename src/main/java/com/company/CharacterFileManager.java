package com.company;

import java.io.*;
import java.util.ArrayList;

public class CharacterFileManager implements SongReader {
    private static File file = new File("C://Users/Quantox/Desktop/Jukebox.txt");


    public static ArrayList<String> readFile() throws IOException {
        ArrayList<String> fileList = new ArrayList<>();
        InputStream in = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = br.readLine()) != null) {
            fileList.add(line);
        }
        return fileList;
    }

    public static void writeFile(Playlist playlist) throws FileNotFoundException {

        ArrayList<Song> songs = playlist.getSongList();
        BufferedWriter bw = null;
        try {
            String data = Parser.parseOut(songs);
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(data);

        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
