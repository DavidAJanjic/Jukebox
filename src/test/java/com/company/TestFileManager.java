package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestFileManager {

//    @Test
//    public void testFileManager() { //tests both readFile() and writeFile()
//        SongReader sr = new FileManager();
//        Playlist playlist = new Playlist();
//        List<Song> songs = new ArrayList<>();
//        Song s1 = new Song("Turbulentno", "Ceca","Folk",5.0,196,0);
//        Song s2 = new Song("Crno i zlatno", "Seka Aleksic","Folk",5.0,250,0);
//        songs.add(s1);
//        songs.add(s2);
//        playlist.setSongList(songs);
//        sr.writeFile(playlist);
//        songs = sr.readFile();
//        assertEquals(songs.get(0).getSongName(),"Turbulentno");
//        assertEquals(songs.get(1).getSongName(),"Crno i zlatno");
//    }

    @Test
    public void testReadFile() {
        SongReader sr = new FileManager();
        List<Song> songs;
        songs = sr.readFile();
        assertEquals(songs.get(0).getSongName(), "Moja Stikla");
    }
}
