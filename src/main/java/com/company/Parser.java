package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static ArrayList<Song> parse(List<String> fileList) {
        ArrayList<Song> playlist = new ArrayList<>();
        for (String line : fileList) {
            Song song = new Song();
            String[] s1 = line.split("-", 2);
            song.setArtistName(s1[0]);
            String[] s2 = s1[1].split(",", 2);
            song.setSongName(s2[0]);
            String[] s3 = s2[1].split(",", 2);
            song.setGenre(s3[0]);
            String[] s4 = s3[1].split(",", 2);
            song.setDuration(Integer.parseInt(s4[0]));
            String[] s5 = s4[1].split(",", 2);
            song.setRating(Double.parseDouble(s5[0]));
            song.setTimesPlayed(Integer.parseInt(s5[1]));

            playlist.add(song);
        }
        return playlist;
    }

    public static ArrayList<Song> parse(String string) {
        ArrayList<Song> playlist = new ArrayList<>();
        String[] list = string.split("\n");
        List<String> stringList = Arrays.asList(list);
        for (String line : stringList) {
            Song song = new Song();
            String[] s1 = line.split("-", 2);
            song.setArtistName(s1[0]);
            String[] s2 = s1[1].split(",", 2);
            song.setSongName(s2[0]);
            String[] s3 = s2[1].split(",", 2);
            song.setGenre(s3[0]);
            String[] s4 = s3[1].split(",", 2);
            song.setDuration(Integer.parseInt(s4[0]));
            String[] s5 = s4[1].split(",", 2);
            song.setRating(Double.parseDouble(s5[0]));
            song.setTimesPlayed(Integer.parseInt(s5[1]));

            playlist.add(song);
        }
        return playlist;
    }

    public static String parseOut(ArrayList<Song> songs) {
        String result = "";
        for (Song x : songs) {
            result += x.getArtistName() + "-" + x.getSongName() + "," + x.getGenre() + ","
                    + x.getDuration() + "," + x.getRating() + "," + x.getTimesPlayed() + "\n";
        }
        return result;
    }
}
