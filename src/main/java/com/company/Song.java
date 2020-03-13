package com.company;

import java.io.Serializable;

public class Song implements Serializable {


    private static final long serialVersionUID = -626879714821753680L;

    private String songName;
    private String artistName;
    private String genre;
    private double rating;
    private int duration;
    private int timesPlayed;

    public Song() {
    }

    public Song(String songName, String artistName, String genre, double rating, int duration, int timesPlayed) {
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.timesPlayed = timesPlayed;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public void play() {
        if (!(Playlist.getPlayedSongs().contains(this))) {
            Playlist.getPlayedSongs().add(this);
            this.timesPlayed = this.timesPlayed + 1;
            System.out.println("Currently listening to " + this.getArtistName() + " - " + this.getSongName()
                    + " | " + this.getTimesPlayed() + ". time");
        } else {
            this.timesPlayed = this.timesPlayed + 1;
            System.out.println("Currently listening to " + this.getArtistName() + " - " + this.getSongName()
                    + " | " + this.getTimesPlayed() + ". time");
        }
    }

    @Override
    public String toString() {
        return getArtistName() + "-" + getSongName() + "," + getGenre() + "," + getDuration() + "," + getRating() +
                "," + getTimesPlayed();
    }
}
