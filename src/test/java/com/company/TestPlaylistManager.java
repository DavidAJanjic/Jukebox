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
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        Song s4 = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        assertEquals(playlist.getSongList().get(0).getSongName(),"Kremen");
        assertEquals(playlist.getSongList().get(1).getSongName(),"Andjela");
        PlaylistManager.orderBySongName(playlist);
        assertEquals(playlist.getSongList().get(0).getSongName(), "Andjela");
        assertEquals(playlist.getSongList().get(1).getSongName(), "Kremen");

    }

    @Test
    public void testOrderingByLength() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        Song s4 = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        assertEquals(playlist.getSongList().get(0).getDuration(),178);
        assertEquals(playlist.getSongList().get(1).getDuration(),287);
        PlaylistManager.orderByLength(playlist);
        assertEquals(playlist.getSongList().get(0).getDuration(), 287);
        assertEquals(playlist.getSongList().get(1).getDuration(), 260);
    }

    @Test
    public void testOredringByRating() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        Song s4 = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        assertEquals(playlist.getSongList().get(0).getRating(),4.5);
        assertEquals(playlist.getSongList().get(1).getRating(),4.9);
        PlaylistManager.orderByRating(playlist);
        assertEquals(playlist.getSongList().get(0).getRating(), 4.9);
        assertEquals(playlist.getSongList().get(1).getRating(), 4.5);
    }

    @Test
    public void testOrderingByArtistName() {
        Song s1 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s2 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        Song s4 = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        assertEquals(playlist.getSongList().get(0).getArtistName(),"Djordje Balasevic");
        assertEquals(playlist.getSongList().get(1).getArtistName(),"Dino Merlin");
        PlaylistManager.orderByArtistName(playlist);
        assertEquals(playlist.getSongList().get(0).getArtistName(), "Dino Merlin");
        assertEquals(playlist.getSongList().get(1).getArtistName(), "Djordje Balasevic");
    }

    @Test
    public void testOrderingByGenre() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        Song s4 = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        assertEquals(playlist.getSongList().get(0).getGenre(),"Zabavna");
        assertEquals(playlist.getSongList().get(1).getGenre(), "Balada");
        PlaylistManager.orderByGenre(playlist);
        assertEquals(playlist.getSongList().get(0).getGenre(), "Balada");
        assertEquals(playlist.getSongList().get(1).getGenre(), "Ex-Yu");
    }

    @Test
    public void testAdd() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        assertEquals(songs.get(songs.size()-1).getSongName(),"Pjevam danju pjevam nocu");
        Song s4 = new Song("Ruzmarin", "Sasa Matic", "Narodna", 4.5, 247, 0);
        PlaylistManager.add(playlist, s4);
        assertEquals(songs.get(songs.size() - 1).getSongName(), "Ruzmarin");
        assertEquals(songs.get(songs.size() - 1).getGenre(), "Narodna");
    }

    @Test
    public void testRemoveWithInt() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        PlaylistManager.remove(playlist, 0);
        SongReader sr = FileManagerFactory.createSongReader(Manager.FileManager);
        sr.writeFile(playlist);
        songs = sr.readFile();
        assertEquals(songs.size(), 2);
        assertEquals(songs.get(0).getSongName(), "Andjela");
    }

    @Test
    public void testRemoveWithSongName() {
        Song s1 = new Song("Kremen", "Dino Merlin", "Zabavna", 4.5, 178, 0);
        Song s2 = new Song("Andjela", "Djordje Balasevic", "Balada", 4.9, 287, 0);
        Song s3 = new Song("Pjevam danju pjevam nocu", "Zdravko Colic", "Ex-Yu", 4.4, 260, 0);
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        PlaylistManager.remove(playlist,"Kremen");
        SongReader sr = FileManagerFactory.createSongReader(Manager.FileManager);
        sr.writeFile(playlist);
        songs = sr.readFile();
        assertEquals(songs.size(), 2);
        assertEquals(songs.get(0).getSongName(), "Andjela");
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
