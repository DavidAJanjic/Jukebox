package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestSong {

    @Test
    public void testPlay() {
        SongReader sr = new FileManager();
        List<Song> songs;
        songs = sr.readFile();
        songs.get(2).play();
        PlaylistManager.setPlayedSongs(songs);
        Song s1 = Playlist.getPlayedSongs().get(2);
        assertEquals(s1.getSongName(), "Znam");
        assertEquals(s1.getTimesPlayed(), 1);
        songs.get(0).play();

    }
}
