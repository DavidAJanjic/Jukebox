package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterFileManager implements SongReader {


    @Override
    public List<Song> readFile() {
        List<String> fileList = new ArrayList<>();
        InputStream in = null;
        try {
            in = new FileInputStream(AppConfig.filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
                fileList.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Song> songs;
        songs = Parser.parse(fileList);
        return songs;
    }

    @Override
    public void writeFile(Playlist playlist) {

        List<Song> songs = playlist.getSongList();
        BufferedWriter bw = null;
        try {
            String data = Parser.parseOut(songs);
            FileWriter fw = new FileWriter(AppConfig.filepath);
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
