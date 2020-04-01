package com.company;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestParser {

    @Test
    public void testParseStringList() throws FileNotFoundException {
        List<Song> playList = Parser.parse(FileManager.readFile());
        assertNotNull(playList);
        assertTrue(!playList.isEmpty());
        Song natasaBekvalac = playList.get(2);
        assertEquals(natasaBekvalac.getArtistName(), "Natasa Bekvalac");
        assertEquals(natasaBekvalac.getSongName(), "Ja sam dobro");
        assertEquals(natasaBekvalac.getDuration(), 238);
        assertEquals(natasaBekvalac.getGenre(), "Pop");
        assertEquals(natasaBekvalac.getRating(), 4.7);

        Song JovanaNiolicNajbolja = playList.get(1);
        assertEquals(JovanaNiolicNajbolja.getArtistName(), "Jovana Nikolic");
        assertEquals(JovanaNiolicNajbolja.getSongName(), "Najbolja");
        assertEquals(JovanaNiolicNajbolja.getDuration(), 192);
        assertEquals(JovanaNiolicNajbolja.getGenre(), "Pop");
        assertEquals(JovanaNiolicNajbolja.getRating(), 4.2);
    }

    @Test
    public void testParseOut() throws FileNotFoundException {
        ArrayList<Song> songs = new ArrayList<>();
        Song s1 = new Song("Merak", "Zdravko Colic", "Folk", 4.9, 211, 0);
        Song s2 = new Song("Svicarska", "Dino Merlin", "Zabavna", 4.8, 312, 0);
        songs.add(s1);
        songs.add(s2);
        Playlist playlist = new Playlist();
        playlist.setSongList(songs);
        FileManager.writeFile(playlist);
        List<Song> playList = Parser.parse(FileManager.readFile());
        assertEquals(playList.get(0).getSongName(), "Merak");
        assertEquals(playList.get(0).getArtistName(), "Zdravko Colic");
        assertEquals(playList.get(1).getSongName(), "Svicarska");
        assertEquals(playList.get(1).getArtistName(), "Dino Merlin");

    }

    @Test
    public void testParseString() throws IOException {
        String text = ByteFileManager.readFile();
        ArrayList<Song> songs;
        songs = Parser.parse(text);
        assertEquals(songs.get(0).getSongName(),"Turbulentno");
        assertEquals(songs.get(2).getSongName(),"Ja sam dobro");

    }
}
