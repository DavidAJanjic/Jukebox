package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlaylistManager {


    public static void setPlayedSongs(List<Song> songs) {
        ArrayList<Song> playedSongs = new ArrayList<>();
        for (Song x : songs) {
            if (x.getTimesPlayed() > 0) {
                playedSongs.add(x);
            }
        }
        Playlist.setPlayedSongs(playedSongs);
    }

    public static void remove(Playlist playlist, int songPlaylistNumber) {
        if (songPlaylistNumber >= playlist.getSongList().size()) {
            System.out.println("Nema pesme na toj poziciji!");
        } else {
            playlist.getSongList().remove(songPlaylistNumber);
        }
    }

    public static void remove(Playlist playlist, String songName) {
        ArrayList<String> songNames = new ArrayList<>();
        for (Song x : playlist.getSongList()){
            songNames.add(x.getSongName());
        }
        if (!(songNames.contains(songName))) {
            System.out.println("Nema te pesme u listi!");
        } else {
            playlist.getSongList().removeIf(x -> x.getSongName().equals(songName));
        }
    }

    public static void add(Playlist playlist, Song song) {
        playlist.getSongList().add(song);
    }

    public static void orderBySongName(Playlist playlist) {
        Collections.sort(playlist.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getSongName().compareTo(o2.getSongName());
            }
        });
    }

    public static void orderByLength(Playlist playlist) {
        Collections.sort(playlist.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (o1.getDuration() > o2.getDuration()) return -1;
                if (o1.getDuration() < o2.getDuration()) return 1;
                return 0;
            }
        });
    }

    public static void orderByRating(Playlist playlist) {
        Collections.sort(playlist.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if (o1.getRating() > o2.getRating()) return -1;
                if (o2.getRating() > o2.getRating()) return 1;
                return 0;
            }
        });
    }

    public static void orderByArtistName(Playlist playlist) {
        Collections.sort(playlist.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getArtistName().compareTo(o2.getArtistName());
            }
        });
    }

    public static void orderByGenre(Playlist playlist) {
        Collections.sort(playlist.getSongList(), new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return o1.getGenre().compareTo(o2.getGenre());
            }
        });
    }

}
