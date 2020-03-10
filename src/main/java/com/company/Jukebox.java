package com.company;

import java.io.FileNotFoundException;

public class Jukebox {

    public static void main(String[] args) {
        SongList plejlista = new SongList();
        try {
            plejlista.setSongList(Parser.parse(FileManager.readFile()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        SongList.setPlayedSongs(SongListManager.setPlayedSongs(plejlista.getSongList()));

        System.out.println("\nDEFAULT\n");

        for (Song x : plejlista.getSongList()) {
            System.out.println(x);
        }
        System.out.println();
        plejlista.getSongList().get(3).play();
        System.out.println();
        plejlista.getSongList().get(5).play();
        System.out.println();

        System.out.println("\nPRESLUSANE\n");

        for (Song x : SongList.getPlayedSongs()) {
            System.out.println(x);
        }

        System.out.println("\nDUZINA \n");
        SongListManager.orderByLength(plejlista);

        for (Song x : plejlista.getSongList()) {
            System.out.println(x);
        }

        SongListManager.orderByRating(plejlista);
        System.out.println("\nRATING\n");

        for (Song x : plejlista.getSongList()) {
            System.out.println(x);
        }

        System.out.println("\nNAZIV PESME\n");
//        SongListManager.remove(SongList.getListaPesama().get(1));

        SongListManager.orderBySongName(plejlista);
        System.out.println();
        for (Song x : plejlista.getSongList()) {
            System.out.println(x);
        }

        System.out.println("\nIME PEVACA\n");
        SongListManager.orderByArtistName(plejlista);
        System.out.println();
        for (Song x : plejlista.getSongList()) {
            System.out.println(x);
        }

        System.out.println("\nZANR\n");
        SongListManager.orderByGenre(plejlista);
        System.out.println();
        for (Song x : plejlista.getSongList()) {
            System.out.println(x);
        }

        try {
            FileManager.writeFile(plejlista);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

    }
}
