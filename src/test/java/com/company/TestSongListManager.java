package com.company;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class TestSongListManager {

    @Test
    public void testOrderBySongName() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        assertEquals(songList.getSongList().get(0).getSongName(), "Pazi skime spavas");
        assertEquals(songList.getSongList().get(1).getSongName(), "Turbulentno");

        SongListManager.orderBySongName(songList);
        assertEquals(songList.getSongList().get(0).getSongName(), "Damelo");
        assertEquals(songList.getSongList().get(1).getSongName(), "Ja sam dobro");

    }

    @Test
    public void testOrderingByLength() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        assertEquals(songList.getSongList().get(0).getDuration(), 242);
        assertEquals(songList.getSongList().get(1).getDuration(), 196);

        SongListManager.orderByLength(songList);
        assertEquals(songList.getSongList().get(0).getDuration(), 252);
        assertEquals(songList.getSongList().get(1).getDuration(), 242);
    }

    @Test
    public void testOredringByRating() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        assertEquals(songList.getSongList().get(0).getRating(), 4.6);
        assertEquals(songList.getSongList().get(1).getRating(), 5.0);

        SongListManager.orderByRating(songList);
        assertEquals(songList.getSongList().get(0).getRating(), 5.0);
        assertEquals(songList.getSongList().get(1).getRating(), 4.9);
    }

    @Test
    public void testOrderingByArtistName() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        assertEquals(songList.getSongList().get(0).getArtistName(), "Ceca");
        assertEquals(songList.getSongList().get(1).getArtistName(), "Ceca");

        SongListManager.orderByArtistName(songList);
        assertEquals(songList.getSongList().get(0).getArtistName(), "Ana Kokic");
        assertEquals(songList.getSongList().get(1).getArtistName(), "Ceca");
    }

    @Test
    public void testOrderingByGenre() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        assertEquals(songList.getSongList().get(0).getGenre(), "Pop-Folk");
        assertEquals(songList.getSongList().get(1).getGenre(), "Folk");
        SongListManager.orderByGenre(songList);
        assertEquals(songList.getSongList().get(0).getGenre(), "Folk");
        assertEquals(songList.getSongList().get(1).getGenre(), "Pop");
    }

    @Test
    public void testAdd() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        Song song = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247);
        SongListManager.add(songList, song);
        assertEquals(songs.get(songs.size()-1).getSongName(), "Ruzmarin");
        assertEquals(songs.get(songs.size()-1).getGenre(), "Narodna");
    }

    @Test
    public void testRemoveWithInt() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        Song song = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247);
        songs.add(song);
        SongListManager.remove(songList, 7);
        assertEquals(songs.size(),7);
        SongListManager.remove(songList, 7);
        assertEquals(songs.size(), 7);
    }

    @Test
    public void testRemoveWithObject() throws FileNotFoundException {
        SongList songList = new SongList();
        ArrayList<Song> songs;
        songs = Parser.parse(FileManager.readFile());
        songList.setSongList(songs);
        Song song = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247);
        songs.add(song);
        SongListManager.remove(songList, song);
        assertEquals(songs.size(),7);
        SongListManager.remove(songList, song);
        assertEquals(songs.size(), 7);
    }
}
