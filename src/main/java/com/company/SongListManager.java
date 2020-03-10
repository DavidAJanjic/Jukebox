package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SongListManager {


    public static ArrayList<Song> setPlayedSongs(ArrayList<Song> songs) {
        ArrayList<Song> playedSongs = new ArrayList<>();
        for (Song x : songs) {
            if (x.getTimesPlayed() > 0) {
                playedSongs.add(x);
            }
        }
        return playedSongs;
    }

    public static void remove(SongList songList, int songPlaylistNumber) {
        if (songPlaylistNumber >= songList.getSongList().size()) {
            System.out.println("Nema pesme na toj poziciji!");
        } else {
            songList.getSongList().remove(songPlaylistNumber);
        }
    }

    public static void remove(SongList songList, Song song) {
        if (!(songList.getSongList().contains(song))) {
            System.out.println("Nema te pesme u listi!");
        } else {
            songList.getSongList().remove(song);
        }
    }

    public static void add(SongList songList, Song song) {
        songList.getSongList().add(song);
    }

    public static void orderBySongName(SongList songList) {
        Collections.sort(songList.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getSongName().compareTo(o2.getSongName());
            }
        });
    }

    public static void orderByLength(SongList songList) {
        Collections.sort(songList.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (o1.getDuration() > o2.getDuration()) return -1;
                if (o1.getDuration() < o2.getDuration()) return 1;
                return 0;
            }
        });
    }

    public static void orderByRating(SongList songList) {
        Collections.sort(songList.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (o1.getRating() > o2.getRating()) return -1;
                if (o2.getRating() > o2.getRating()) return 1;
                return 0;
            }
        });
    }

    public static void orderByArtistName(SongList songList) {
        Collections.sort(songList.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getArtistName().compareTo(o2.getArtistName());
            }
        });
    }

    public static void orderByGenre(SongList songList) {
        Collections.sort(songList.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getGenre().compareTo(o2.getGenre());
            }
        });
    }

}
