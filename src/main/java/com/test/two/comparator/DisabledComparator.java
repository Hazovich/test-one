package com.test.two.comparator;

import com.test.two.User;

import java.util.Comparator;

public class DisabledComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return Boolean.compare(o1.isDisabled(), o2.isDisabled());
    }
}
