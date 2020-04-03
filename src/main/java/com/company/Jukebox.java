package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class Jukebox {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        FileManagerFactory fmf = new FileManagerFactory();
        SongReader songReader = fmf.createSongReader(Manager.FileManager);
        playlist.setSongList(songReader.readFile());

        PlaylistManager.setPlayedSongs(playlist.getSongList());

        System.out.println("\nDEFAULT\n");

        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }
        System.out.println();
        playlist.getSongList().get(2).play();
        System.out.println();
        playlist.getSongList().get(1).play();
        System.out.println();

        System.out.println("\nLISTENED\n");

        for (Song x : Playlist.getPlayedSongs()) {
            System.out.println(x);
        }

        System.out.println("\nLENGTH\n");
        PlaylistManager.orderByLength(playlist);

        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }

        PlaylistManager.orderByRating(playlist);
        System.out.println("\nRATING\n");

        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }

        System.out.println("\nSONG NAME\n");


        PlaylistManager.orderBySongName(playlist);
        System.out.println();
        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }

        System.out.println("\nARTIST NAME\n");
        PlaylistManager.orderByArtistName(playlist);
        System.out.println();
        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }

        System.out.println("\nGENRE\n");
        PlaylistManager.orderByGenre(playlist);
        System.out.println();
        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }

        System.out.println();
        songReader.writeFile(playlist);
    }
}
