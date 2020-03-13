package com.company;

import java.io.*;


public class ByteFileManager implements SongReader {
    private static File file = new File("C://Users/Quantox/Desktop/Jukebox.txt");

    public static String readFile() throws IOException {
        FileInputStream in = null;
        BufferedInputStream bin = null;
        StringBuilder line = new StringBuilder();
        try {
            in = new FileInputStream(file);
            bin = new BufferedInputStream(in);

            while (bin.available() > 0) {
                line.append((char) bin.read());
            }
        } finally {
            try {
                if (bin != null | in != null) {
                    bin.close();
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return line.toString();

    }

    public static void writeFile(Playlist playlist) throws IOException {
        String text = Parser.parseOut(playlist.getSongList());
        FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(file);
            byte[] textInBytes = text.getBytes();
            fop.write(textInBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fop.flush();
            fop.close();
        }

    }
}
