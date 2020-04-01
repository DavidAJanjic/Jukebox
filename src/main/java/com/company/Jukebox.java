package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class Jukebox {

    public static void main(String[] args) {
//        SongReader reader = new CharacterFileManager();
//        SongReader reader = new ByteFileManager();
//        Jukebox jb = new Jukebox(reader);
//        reader.readListOfSongs();

        Playlist playlist = new Playlist();
        try {
//            playlist.setSongList(Parser.parse(CharacterFileManager.readFile()));
//            ObjectIO.writeFile(playlist);
            playlist.setSongList(ObjectIO.readFile());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Playlist.setPlayedSongs(PlaylistManager.setPlayedSongs(playlist.getSongList()));

        System.out.println("\nDEFAULT\n");

        for (Song x : playlist.getSongList()) {
            System.out.println(x);
        }
        System.out.println();
        playlist.getSongList().get(3).play();
        System.out.println();
        playlist.getSongList().get(5).play();
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
//        SongListManager.remove(SongList.getListaPesama().get(1));

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
        ObjectIO.writeFile(playlist);

//        try{
//            CharacterFileManager.writeFile(playlist);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
