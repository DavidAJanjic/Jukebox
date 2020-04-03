package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ByteFileManager implements SongReader {


    @Override
    public List<Song> readFile() {
        FileInputStream in = null;
        BufferedInputStream bin = null;
        StringBuilder line = new StringBuilder();
        try {
            in = new FileInputStream(AppConfig.filepath);
            bin = new BufferedInputStream(in);

            while (bin.available() > 0) {
                line.append((char) bin.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bin != null) {
                    bin.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Song> songs;
        songs = Parser.parse(line.toString());
        return songs;
    }

    @Override
    public void writeFile(Playlist playlist) {
        String text = Parser.parseOut(playlist.getSongList());
        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(AppConfig.filepath);
            byte[] textInBytes = text.getBytes();
            fop.write(textInBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fop.flush();
                fop.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
