package com.company;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static org.testng.Assert.*;

public class TestFileManager {

    @Test
    public void testFileManager() throws FileNotFoundException { //tests both readFile() and writeFile()
        Playlist playlist = new Playlist();
        ArrayList<Song> songs = new ArrayList<>();
        Song s1 = new Song("Turbulentno", "Ceca","Folk",5.0,196,0);
        Song s2 = new Song("Crno i zlatno", "Seka Aleksic","Folk",5.0,250,0);
        songs.add(s1);
        songs.add(s2);
        playlist.setSongList(songs);
        FileManager.writeFile(playlist);
        songs = Parser.parse(FileManager.readFile());
        assertEquals(songs.get(0).getSongName(),"Turbulentno");
        assertEquals(songs.get(1).getSongName(),"Crno i zlatno");
    }
}
