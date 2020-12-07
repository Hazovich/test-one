package com.test.two.comparator;

import com.test.two.User;

import java.util.Comparator;

public class NameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getUser().compareTo(o2.getUser());
    }
}
