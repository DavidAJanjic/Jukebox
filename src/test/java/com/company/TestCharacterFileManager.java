package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class TestCharacterFileManager {

    @Test
    public void testReadFile() throws IOException { //sa ArrayList<String>()
        Playlist playlist = new Playlist();
        playlist.setSongList(Parser.parse(CharacterFileManager.readFile()));
        assertEquals(playlist.getSongList().get(4).getSongName(), "Zauvek");
    }

    @Test
    public void testWriteFile() throws  IOException{
        Playlist playlist = new Playlist();
        ArrayList<Song> songs = new ArrayList<>();
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        songs.add(s1);
        songs.add(s2);
        playlist.setSongList(songs);
        CharacterFileManager.writeFile(playlist);
        songs = Parser.parse(CharacterFileManager.readFile());
        assertEquals(songs.get(0).getSongName(),"Kremen");

    }
}
