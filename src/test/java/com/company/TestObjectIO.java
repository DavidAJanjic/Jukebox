package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestObjectIO {

    @Test
    public void testReadAndWriteFile() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);

        SongReader sr = FileManagerFactory.createSongReader(Manager.ObjectIO);
        sr.writeFile(playlist);
        songs = sr.readFile();
        assertEquals(songs.get(0).getSongName(), "Kremen");
        assertEquals(songs.get(2).getDuration(), 260);
    }

}
