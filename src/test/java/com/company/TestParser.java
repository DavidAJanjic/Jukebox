package com.company;

import org.junit.jupiter.api.Test;
import static org.testng.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestParser {

    @Test
    public void testParse() throws FileNotFoundException {
//        Parser parser = new Parser();
        List<Song> playList = Parser.parse(FileManager.readFile());
        assertNotNull(playList);
        assertTrue(!playList.isEmpty());
        Song NatasaBekvalac = playList.get(3);
        assertEquals(NatasaBekvalac.getArtistName(), "Natasa Bekvalac");
        assertEquals(NatasaBekvalac.getSongName(), "Ja sam dobro");
        assertEquals(NatasaBekvalac.getDuration(),238);
        assertEquals(NatasaBekvalac.getGenre(),"Pop");
        assertEquals(NatasaBekvalac.getRating(),4.7);

        Song JovanaNiolicNajbolja = playList.get(2);
        assertEquals(JovanaNiolicNajbolja.getArtistName(), "Jovana Nikolic");
        assertEquals(JovanaNiolicNajbolja.getSongName(), "Najbolja");
        assertEquals(JovanaNiolicNajbolja.getDuration(),192);
        assertEquals(JovanaNiolicNajbolja.getGenre(),"Pop");
        assertEquals(JovanaNiolicNajbolja.getRating(),4.2);
    }

    @Test
    public void testParseOut() throws FileNotFoundException {
        ArrayList<Song> songs = new ArrayList<>();
        Song s1 = new Song("Merak","Zdravko Colic","Folk",4.9,211);
        Song s2 = new Song("Svicarska","Dino Merlin","Zabavna",4.8,312);
        songs.add(s1);
        songs.add(s2);
        SongList songList = new SongList();
        songList.setSongList(songs);
        FileManager.writeFile(songList);
        List<Song> playList = Parser.parse(FileManager.readFile());
        assertEquals(playList.get(0).getSongName(), "Merak");
        assertEquals(playList.get(0).getArtistName(),"Zdravko Colic");
        assertEquals(playList.get(1).getSongName(),"Svicarska");
        assertEquals(playList.get(1).getArtistName(),"Dino Merlin");

    }
}
