package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class TestByteFileManager {

    @Test
    public void testReadFile() throws IOException {
        ArrayList<Song> songs;
        songs = Parser.parse(ByteFileManager.readFile());
        assertEquals(songs.get(5).getSongName(), "Damelo");
    }

    @Test
    public void testWriteFile() throws IOException {
        Playlist playlist = new Playlist();
        ArrayList<Song> songs = new ArrayList<>();
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        songs.add(s1);
        songs.add(s2);
        playlist.setSongList(songs);
        ByteFileManager.writeFile(playlist);
        songs = Parser.parse(ByteFileManager.readFile());
        assertEquals(songs.get(1).getSongName(), "Andjela");
    }
}
