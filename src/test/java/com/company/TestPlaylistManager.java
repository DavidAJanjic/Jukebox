package com.company;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestPlaylistManager {

    @Test
    public void testOrderBySongName() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        PlaylistManager.orderBySongName(playlist);
        assertEquals(playlist.getSongList().get(0).getSongName(), "Damelo");
        assertEquals(playlist.getSongList().get(1).getSongName(), "Ja sam dobro");

    }

    @Test
    public void testOrderingByLength() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        PlaylistManager.orderByLength(playlist);
        assertEquals(playlist.getSongList().get(0).getDuration(), 252);
        assertEquals(playlist.getSongList().get(1).getDuration(), 242);
    }

    @Test
    public void testOredringByRating() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        PlaylistManager.orderByRating(playlist);
        assertEquals(playlist.getSongList().get(0).getRating(), 5.0);
        assertEquals(playlist.getSongList().get(1).getRating(), 4.9);
    }

    @Test
    public void testOrderingByArtistName() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        PlaylistManager.orderByArtistName(playlist);
        assertEquals(playlist.getSongList().get(0).getArtistName(), "Ana Kokic");
        assertEquals(playlist.getSongList().get(1).getArtistName(), "Ceca");
    }

    @Test
    public void testOrderingByGenre() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        PlaylistManager.orderByGenre(playlist);
        assertEquals(playlist.getSongList().get(0).getGenre(), "Folk");
        assertEquals(playlist.getSongList().get(1).getGenre(), "Pop");
    }

    @Test
    public void testAdd() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        Song song = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        PlaylistManager.add(playlist, song);
        assertEquals(songs.get(songs.size() - 1).getSongName(), "Ruzmarin");
        assertEquals(songs.get(songs.size() - 1).getGenre(), "Narodna");
    }

    @Test
    public void testRemoveWithInt() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        Song song = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        songs.add(song);
        PlaylistManager.remove(playlist, 7);
        assertEquals(songs.size(), 7);
        PlaylistManager.remove(playlist, 7);
        assertEquals(songs.size(), 7);
    }

    @Test
    public void testRemoveWithObject() {
        SongReader sr = new FileManager();
        Playlist playlist = new Playlist();
        List<Song> songs;
        songs = sr.readFile();
        playlist.setSongList(songs);
        Song song = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        songs.add(song);
        PlaylistManager.remove(playlist, song);
        assertEquals(songs.size(), 7);
        PlaylistManager.remove(playlist, song);
        assertEquals(songs.size(), 7);
    }

    @Test
    public void testSetPlayedSongs() {
        List<Song> songs = new ArrayList<>();
        Song s1 = new Song("Merak", "Zdravko Colic", "Folk", 4.9, 211, 0);
        Song s2 = new Song("Svicarska", "Dino Merlin", "Zabavna", 4.8, 312, 0);
        songs.add(s1);
        songs.add(s2);
        Playlist.setPlayedSongs(songs);
        assertEquals(Playlist.getPlayedSongs().get(1).getSongName(), "Svicarska");
    }
}
