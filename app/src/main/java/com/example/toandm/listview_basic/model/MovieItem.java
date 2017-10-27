package com.example.toandm.listview_basic.model;

/**
 * Created by toandm on 10/26/17.
 */

public class MovieItem {
    private String id;
    private String nameMovie;
    private boolean isWatchLater;
    private int releasedYear;
    private String directedBy;

    public MovieItem(String id, String nameMovie, boolean isWatchLater, int releasedYear, String directedBy) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.isWatchLater = isWatchLater;
        this.releasedYear = releasedYear;
        this.directedBy = directedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public boolean isWatchLater() {
        return isWatchLater;
    }

    public void setWatchLater(boolean watchLater) {
        isWatchLater = watchLater;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }
}
