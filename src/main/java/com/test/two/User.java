package com.test.two;

import java.util.Objects;

public class User {

    private String user;
    private long rating;
    private boolean disabled;

    public User(String name, long rating, boolean disabled) {
        this.user = name;
        this.rating = rating;
        this.disabled = disabled;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return rating == user.rating &&
                disabled == user.disabled &&
                Objects.equals(this.user, user.user);
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 32;
        result = result * prime + (user != null ? user.hashCode() : 0);
        result = result * prime + ((int) (rating ^ (rating >>> 32)));
        result = result * prime + (disabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return
                "\n" + "{" + "\"" + "user" + "\"" + ":" + "\"" + user + "\""
                        + "," + "\"" + "rating" + "\"" + ":" + rating +
                        "," + "\"" + "disabled" + "\"" + ":" + disabled +
                        "}" + "\n";
    }
}
