package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestObjectIO {

    @Test
    public void testWriteObject() {
        SongReader sr = new ObjectIO();
        ArrayList<Song> songs = new ArrayList<>();
        Song s1 = new Song("Merak", "Zdravko Colic", "Folk", 4.9, 211, 0);
        Song s2 = new Song("Svicarska", "Dino Merlin", "Zabavna", 4.8, 312, 0);
        songs.add(s1);
        songs.add(s2);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        sr.writeFile(playlist);
    }

    @Test
    public void testReadObject() {
        SongReader sr = new ObjectIO();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        songs = playlist.getSongList();
        assertEquals(songs.get(0).getSongName(), "Merak");
        System.out.println(songs.get(1));
    }
}
