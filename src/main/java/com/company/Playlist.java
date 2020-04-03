package com.company;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songList = new ArrayList<>();
    private static List<Song> playedSongs = new ArrayList<>();

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public static List<Song> getPlayedSongs() {
        return playedSongs;
    }

    public static void setPlayedSongs(List<Song> playedSongs) {
        Playlist.playedSongs = playedSongs;
    }
}
