package com.company;

import java.util.ArrayList;

public class SongList  {

    private ArrayList<Song> songList = new ArrayList<>();
    private static ArrayList<Song> playedSongs = new ArrayList<>();

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }

    public static ArrayList<Song> getPlayedSongs() {
        return playedSongs;
    }

    public static void setPlayedSongs(ArrayList<Song> playedSongs) {
        SongList.playedSongs = playedSongs;
    }
}
