package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class TestSong {

    @Test
    public void testPlay() throws FileNotFoundException {
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songs.get(0).play();
        Song s1 = SongList.getPlayedSongs().get(0);
        assertEquals(s1.getSongName(),"Turbulentno");
        assertEquals(s1.getTimesPlayed(),2);
        songs.get(0).play();

    }
}
