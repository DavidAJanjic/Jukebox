package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestByteFileManager {

    @Test
    public void testReadFile() {
        SongReader sr = FileManagerFactory.createSongReader(Manager.ByteFileManager);
        List<Song> songs;
        songs = sr.readFile();
        assertEquals(songs.get(0).getSongName(), "Znam");
    }

    @Test
    public void testWriteFile() {
        SongReader sr = new ByteFileManager();
        Playlist playlist = new Playlist();
        List<Song> songs = new ArrayList<>();
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        songs.add(s1);
        songs.add(s2);
        playlist.setSongList(songs);
        sr.writeFile(playlist);
        songs = sr.readFile();
        assertEquals(songs.get(1).getSongName(), "Andjela");
    }
}
