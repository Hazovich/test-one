package com.test.two.comparator;

import com.test.two.User;

import java.util.Comparator;

public class RatingComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return (int) o1.getRating() - (int) o2.getRating();
    }
}
