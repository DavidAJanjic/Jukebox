package com.company;

import java.util.ArrayList;

public class Playlist {
    private static int streamType;
    private ArrayList<Song> songList = new ArrayList<>();
    private static ArrayList<Song> playedSongs = new ArrayList<>();


    public static int getStreamType() {
        return streamType;
    }

    public static void setStreamType(int streamType) {
        Playlist.streamType = streamType;
    }

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
        Playlist.playedSongs = playedSongs;
    }
}
