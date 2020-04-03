package com.company;

import org.junit.jupiter.api.Test;

import javax.xml.stream.FactoryConfigurationError;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TestSong {

    @Test
    public void testPlay() {
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
        SongReader sr = FileManagerFactory.createSongReader(Manager.CharacterFileManager);
        songs.get(2).play();
        PlaylistManager.setPlayedSongs(songs);
        assertEquals(Playlist.getPlayedSongs().get(0).getSongName(), "Pjevam danju pjevam nocu");
        assertEquals(Playlist.getPlayedSongs().get(0).getTimesPlayed(), 1);
        songs.get(0).play();

    }
}
